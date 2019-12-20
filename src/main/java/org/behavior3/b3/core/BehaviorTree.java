package org.behavior3.b3.core;

import org.behavior3.b3.config.BTNodeCfg;
import org.behavior3.b3.config.BTTreeCfg;
import org.behavior3.b3.config.DefaultNodes;
import org.behavior3.b3.constant.B3Const;
import org.behavior3.b3.constant.B3Status;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 行为树
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
@Data
@Slf4j
public class BehaviorTree {

    private String id = UUID.randomUUID().toString().replaceAll("-", "");
    private String titile;
    private String description;
    private Map<String, Object> properties = new HashMap<>();

    private BaseNode root;



    public void load(BTTreeCfg cfg) {
        load(cfg, new HashMap<>());
    }


    public void load(BTTreeCfg cfg, Map<String, Class<? extends BaseNode>> extendNodes) {

        this.titile = cfg.getTitle();
        this.description = cfg.getDescription();
        this.properties = cfg.getProperties();

        Map<String, Class<? extends BaseNode>> nodeMaps = new HashMap<>(DefaultNodes.get());
        //加载扩展nodes
        if (extendNodes != null && extendNodes.size() > 0) {
            nodeMaps.putAll(extendNodes);
        }


        Map<String, BaseNode> nodes = new HashMap<>();
        //create  nodes
        for (Map.Entry<String, BTNodeCfg> nodeEntry : cfg.getNodes().entrySet()) {

            String id = nodeEntry.getKey();

            BTNodeCfg nodeCfg = nodeEntry.getValue();

            BaseNode node = null;
            Class<? extends BaseNode> clazz = nodeMaps.get(nodeCfg.getName());
            if (clazz != null) {
                try {
                    node = clazz.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (node == null) {
                log.error("create node erro:{}", nodeCfg.getName());
                break;
            }

            node.initialize(nodeCfg);

            nodes.put(id, node);

        }


        /**
         * connect the nodes
         */
        for (Map.Entry<String, BTNodeCfg> nodeEntry : cfg.getNodes().entrySet()) {
            BaseNode node = nodes.get(nodeEntry.getKey());
            BTNodeCfg nodeCfg = nodeEntry.getValue();

            if (node.getCategory().equals(B3Const.COMPOSITE) && nodeCfg.getChildren() != null) {
                for (String cid : nodeCfg.getChildren()) {
                    IComposite comp = (IComposite) node;
                    comp.addChild(nodes.get(cid));
                }

            } else if (node.getCategory().equals(B3Const.DECORATOR) && nodeCfg.getChild().length() > 0) {
                IDecorator deco = (IDecorator) node;
                deco.setChild(nodes.get(nodeCfg.getChild()));
            }


        }


        //设置root节点
        this.root = nodes.get(cfg.getRoot());

    }


    public <T> B3Status tick(T t, Blackboard blackboard) {

        if (blackboard == null) {
            log.error("The blackboard parameter is obligatory and must be an instance of b3.Blackboard");
            return B3Status.ERROR;
        }

        /* CREATE A TICK OBJECT */
        Tick tick = new Tick();
        tick.setTarget(t);
        tick.setBlackboard(blackboard);
        tick.setTree(this);


        B3Status status = this.root.run(tick);

        List<BaseNode> lastOpenNodes = blackboard.getTreeData(this.id).openNodes;

        List<BaseNode> currOpenNodes = tick.getOpenNodes();

        // does not close if it is still open in this tick
        int start = 0;
        for (int i = 0; i < (lastOpenNodes.size() > currOpenNodes.size() ? currOpenNodes.size() : lastOpenNodes.size()); i++) {
            start = i + 1;
            if (lastOpenNodes.get(i) != currOpenNodes.get(i)) {
                break;
            }
        }

        // close the nodes
        for (int i = lastOpenNodes.size() - 1; i >= start; i--) {
            lastOpenNodes.get(i).close(tick);
        }

        /* POPULATE BLACKBOARD */
        blackboard.getTreeData(this.id).openNodes = currOpenNodes;
        blackboard.SetTree("nodeCount", tick.getNodeCount(), this.id);


        return status;
    }


}

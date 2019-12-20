package org.behavior3.b3;

import org.behavior3.b3.config.BTTreeCfg;
import org.behavior3.b3.config.BevTreeConfig;
import org.behavior3.b3.core.BehaviorTree;
import org.behavior3.b3.core.BaseNode;

import java.util.Map;

/**
 * 行为树加载器
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/9/20.
 */
public class B3Loader {


    /**
     * @param treeJson    行为树配置文件
     * @param extendNodes  自定义扩展结点
     */
    public static BehaviorTree loadB3Tree(String treeJson, Map<String, Class<? extends BaseNode>> extendNodes) {

        //init tree config
        BTTreeCfg btTreeCfg = BevTreeConfig.LoadTreeCfg(treeJson);

        //load treecfg
        BehaviorTree tree = new BehaviorTree();
        if (extendNodes != null && !extendNodes.isEmpty()) {
            tree.load(btTreeCfg, extendNodes);
        } else {
            tree.load(btTreeCfg);
        }

        return tree;

    }

    public static BehaviorTree loadB3Tree(String treeJson) {
        return loadB3Tree(treeJson, null);
    }


}

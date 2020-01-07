package com.github.silencesu.behavior3java;

import com.github.silencesu.behavior3java.config.BTTreeCfg;
import com.github.silencesu.behavior3java.config.BevTreeConfig;
import com.github.silencesu.behavior3java.config.DefaultNodes;
import com.github.silencesu.behavior3java.core.BehaviorTree;
import com.github.silencesu.behavior3java.core.BaseNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 行为树加载器
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/9/20.
 */
public class B3Loader {

    private final static HashMap<String,BTTreeCfg> treeMaps = new HashMap<>(16);
    /**
     * 初始化行为树数据
     * @param treeJsonPath
     */
    public static void initB3Trees(String projectJsonPath) {
        List<BTTreeCfg> btTreeCfgList = BevTreeConfig.LoadTreesCfg(projectJsonPath);
        if(btTreeCfgList != null) {
            for (BTTreeCfg btTreeCfg : btTreeCfgList) {
                treeMaps.put(btTreeCfg.getId(), btTreeCfg);
            }
        }
    }
    /**
     * 初始化行为树数据
     * @param treeJsonPath
     */
    public static void initB3Tree(String treeJsonPath) {
        BTTreeCfg btTreeCfg = BevTreeConfig.LoadTreeCfg(treeJsonPath);
        treeMaps.put(btTreeCfg.getId(), btTreeCfg);
    }

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

    public static BehaviorTree loadB3Tree(String treeId) {
        BTTreeCfg btTreeCfg = treeMaps.get(treeId);
        //load treecfg
        BehaviorTree tree = new BehaviorTree();
        tree.load(btTreeCfg);
        return tree;
    }


}

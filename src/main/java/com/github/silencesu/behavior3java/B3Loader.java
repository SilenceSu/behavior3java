package com.github.silencesu.behavior3java;

import com.github.silencesu.behavior3java.config.BTTreeCfg;
import com.github.silencesu.behavior3java.config.BTTreeProjectCfg;
import com.github.silencesu.behavior3java.config.BevTreeConfig;
import com.github.silencesu.behavior3java.core.BaseNode;
import com.github.silencesu.behavior3java.core.BehaviorTree;
import com.github.silencesu.behavior3java.core.BehaviorTreeProject;

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
     * @param extendNodes 自定义扩展结点
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

    /**
     * 加载工程
     *
     * @param projectJson
     * @param extendNodes
     * @return
     */
    public static BehaviorTreeProject loadB3Project(String projectJson, Map<String, Class<? extends BaseNode>> extendNodes) {
        BTTreeProjectCfg projectCfg = BevTreeConfig.LoadBTTreePorjectCfg(projectJson);
        BehaviorTreeProject project = new BehaviorTreeProject();
        project.initProject(projectCfg, extendNodes);
        return project;
    }


}

package com.github.silencesu.behavior3java;

import com.github.silencesu.behavior3java.actions.Log;
import com.github.silencesu.behavior3java.core.BaseNode;
import com.github.silencesu.behavior3java.core.BehaviorTree;
import com.github.silencesu.behavior3java.core.BehaviorTreeProject;
import com.github.silencesu.behavior3java.core.Blackboard;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试用例
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class Loader {

    //自定义扩展log
    private static Map<String, Class<? extends BaseNode>> extendNodes = new HashMap<String, Class<? extends BaseNode>>() {
        {
            put("Log", Log.class);
        }
    };


    @Test
    public void loadTree() {
        String confJson = Loader.class.getResource("/").getPath() + "tree.json";
        BehaviorTree behaviorTree = B3Loader.loadB3Tree(confJson, extendNodes);
        Blackboard blackboard = new Blackboard();
        behaviorTree.tick(new Object(), blackboard);
    }

    @Test
    public void loadProject() {
        String confJson = Loader.class.getResource("/").getPath() + "project.b3";
        BehaviorTreeProject behaviorTreeProject = B3Loader.loadB3Project(confJson, extendNodes);
        Blackboard blackboard = new Blackboard();
        BehaviorTree behaviorTree = behaviorTreeProject.findBTTreeByTitle("tree1");
        behaviorTree.tick(new Object(), blackboard);


    }
}

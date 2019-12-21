package com.susu;

import com.github.silencesu.behavior3java.B3Loader;
import com.github.silencesu.behavior3java.actions.Log;
import com.github.silencesu.behavior3java.core.BaseNode;
import com.github.silencesu.behavior3java.core.BehaviorTree;
import com.github.silencesu.behavior3java.core.Blackboard;

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

    public static void main(String[] args) {

        //自定义扩展log
        Map<String, Class<? extends BaseNode>> extendNodes = new HashMap<String, Class<? extends BaseNode>>() {
            {
                put("Log", Log.class);
            }
        };



        String confJson = Loader.class.getResource("/").getPath() + "tree.json";
        BehaviorTree behaviorTree = B3Loader.loadB3Tree(confJson, extendNodes);
        Blackboard blackboard = new Blackboard();
        behaviorTree.tick(new Object(), blackboard);


    }
}

package com.github.silencesu.behavior3java.config;

import com.github.silencesu.behavior3java.actions.Error;
import com.github.silencesu.behavior3java.actions.*;
import com.github.silencesu.behavior3java.composites.MemPriority;
import com.github.silencesu.behavior3java.composites.MemSequence;
import com.github.silencesu.behavior3java.composites.Priority;
import com.github.silencesu.behavior3java.composites.Sequence;
import com.github.silencesu.behavior3java.core.BaseNode;
import com.github.silencesu.behavior3java.core.SubTree;
import com.github.silencesu.behavior3java.decorators.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认节点
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/6.
 */
public class DefaultNodes {
    /**
     * 注册支持的节点
     * key name
     * value node class
     */
    private static Map<String, Class<? extends BaseNode>> defaultNodes = new HashMap<>();



    static {
        //actions
        defaultNodes.put("Error", Error.class);
        defaultNodes.put("Failer", Failer.class);
        defaultNodes.put("Runner", Runner.class);
        defaultNodes.put("Succeeder", Succeeder.class);
        defaultNodes.put("Wait", Wait.class);
        defaultNodes.put("SubTree", SubTree.class);

        //composites
        defaultNodes.put("MemPriority", MemPriority.class);
        defaultNodes.put("MemSequence", MemSequence.class);
        defaultNodes.put("Priority", Priority.class);
        defaultNodes.put("Sequence", Sequence.class);

        //decorators
        defaultNodes.put("Inverter", Inverter.class);
        defaultNodes.put("Limiter", Limiter.class);
        defaultNodes.put("MaxTime", MaxTime.class);
        defaultNodes.put("Repeater", Repeater.class);
        defaultNodes.put("RepeatUntilFailure", RepeatUntilFailure.class);
        defaultNodes.put("RepeatUntilSuccess", RepeatUntilSuccess.class);


    }
    /**
     * 扩充Nodes节点
     */
    public static Map<String,Class<? extends BaseNode>> extendCustomNodes(Map<String,Class<? extends BaseNode>> maps) {
        defaultNodes.putAll(maps);
        return defaultNodes;
    }

    public static Map<String,Class<? extends BaseNode>> get(){
        return defaultNodes;
    }

}

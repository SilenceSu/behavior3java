package com.susu.b3.config;

import com.susu.b3.actions.Error;
import com.susu.b3.actions.*;
import com.susu.b3.composites.MemPriority;
import com.susu.b3.composites.MemSequence;
import com.susu.b3.composites.Priority;
import com.susu.b3.composites.Sequence;
import com.susu.b3.core.BaseNode;
import com.susu.b3.decorators.*;

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

    public static Map<String,Class<? extends BaseNode>> get(){
        return defaultNodes;
    }

}

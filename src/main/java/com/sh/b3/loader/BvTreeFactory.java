package com.sh.b3.loader;

import com.sh.b3.actions.Error;
import com.sh.b3.actions.*;
import com.sh.b3.composites.MemPriority;
import com.sh.b3.composites.MemSequence;
import com.sh.b3.composites.Priority;
import com.sh.b3.composites.Sequence;
import com.sh.b3.config.BTTreeCfg;
import com.sh.b3.core.BaseNode;
import com.sh.b3.core.BehaviorTree;
import com.sh.b3.decorators.*;

import java.util.HashMap;
import java.util.Map;

/**
 * bv树节点
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class BvTreeFactory {
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
        defaultNodes.put("Log", Log.class);

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



    public static BehaviorTree createBtTreeFromConfig(BTTreeCfg cfg) {

        BehaviorTree bTTree = new BehaviorTree();
        bTTree.load(cfg, defaultNodes);
        return bTTree;
    }

    public static BehaviorTree createBtTreeFromConfig(BTTreeCfg cfg, Map<String, Class<? extends BaseNode>> extNodes) {

        BehaviorTree bTTree = new BehaviorTree();
        defaultNodes.putAll(extNodes);
        bTTree.load(cfg, defaultNodes);
        return bTTree;
    }


}

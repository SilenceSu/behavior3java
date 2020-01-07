package com.github.silencesu.behavior3java.actions;

import com.github.silencesu.behavior3java.config.BTNodeCfg;
import com.github.silencesu.behavior3java.constant.B3Const;
import com.github.silencesu.behavior3java.constant.B3Status;
import com.github.silencesu.behavior3java.core.Tick;
import com.github.silencesu.behavior3java.core.Action;

/**
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class Wait extends Action {

    private long endTime;

    @Override
    public void initialize(BTNodeCfg nodeCfg) {
        super.initialize(nodeCfg);
        String ml = nodeCfg.getProperties().get(B3Const.END_TIME);
        endTime = Long.valueOf(ml);

    }

    @Override
    public void onOpen(Tick tick) {
        super.onOpen(tick);

        long startTime = System.currentTimeMillis();
        tick.getBlackboard().setParam(B3Const.START_TIME, startTime, tick.getTree().getId(), this.getId());

    }

    @Override
    public B3Status onTick(Tick tick) {

        long currentTime = System.currentTimeMillis();
        Long startTime =  tick.getBlackboard().getParam(B3Const.START_TIME, tick.getTree().getId(), this.getId());

        if (currentTime - startTime > this.endTime) {
            return B3Status.SUCCESS;
        }


        return B3Status.RUNNING;
    }

}

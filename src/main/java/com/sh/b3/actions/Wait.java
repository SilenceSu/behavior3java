package com.sh.b3.actions;

import com.sh.b3.config.BTNodeCfg;
import com.sh.b3.constant.B3Const;
import com.sh.b3.constant.B3Status;
import com.sh.b3.core.Action;
import com.sh.b3.core.Tick;

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
        String ml = nodeCfg.getProperties().get(B3Const.MAX_LOOP);
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

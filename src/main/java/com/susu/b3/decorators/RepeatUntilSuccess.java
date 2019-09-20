package com.susu.b3.decorators;

import com.susu.b3.config.BTNodeCfg;
import com.susu.b3.constant.B3Const;
import com.susu.b3.constant.B3Status;
import com.susu.b3.core.Decorator;
import com.susu.b3.core.Tick;

/**
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class RepeatUntilSuccess extends Decorator {
    private int maxLoop;

    @Override
    public void initialize(BTNodeCfg nodeCfg) {
        super.initialize(nodeCfg);
        this.maxLoop = Integer.valueOf(nodeCfg.getProperties().get(B3Const.MAX_LOOP));

    }

    @Override
    public void onOpen(Tick tick) {
        super.onOpen(tick);
        tick.getBlackboard().setParam("i", 0, tick.getTree().getId(), this.getId());

    }

    @Override
    public B3Status onTick(Tick tick) {

        if (this.getChild() == null) {
            return B3Status.FAILURE;
        }

        Integer i =  tick.getBlackboard().getParam("i", tick.getTree().getId(), this.getId());
        B3Status status = B3Status.ERROR;

        while (i < maxLoop) {
            status = this.getChild().execute(tick);
            if (status == B3Status.FAILURE) {
                i++;
            } else {
                break;

            }
        }


        tick.getBlackboard().setParam("i", i, tick.getTree().getId(), this.getId());
        return status;


    }
}

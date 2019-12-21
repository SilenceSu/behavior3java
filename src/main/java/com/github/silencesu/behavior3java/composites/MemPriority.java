package com.github.silencesu.behavior3java.composites;

import com.github.silencesu.behavior3java.constant.B3Const;
import com.github.silencesu.behavior3java.constant.B3Status;
import com.github.silencesu.behavior3java.core.Tick;
import com.github.silencesu.behavior3java.core.Composite;

/**
 * 记忆选择节点
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class MemPriority extends Composite {
    @Override
    public void onOpen(Tick tick) {
        super.onOpen(tick);
        tick.getBlackboard().setParam(B3Const.RUNNING_CHILD, 0, tick.getTree().getId(), this.getId());
    }

    @Override
    public B3Status onTick(Tick tick) {

        Integer childId = tick.getBlackboard().getParam(B3Const.RUNNING_CHILD, tick.getTree().getId(), this.getId());

        for (int i = childId; i < this.getChildCount(); i++) {
            B3Status status = this.getChild(i).execute(tick);

            if (status != B3Status.FAILURE) {

                if (status == B3Status.RUNNING) {
                    tick.getBlackboard().setParam(B3Const.RUNNING_CHILD, i, tick.getTree().getId(), this.getId());
                }

                return status;

            }



        }

        return B3Status.FAILURE;
    }
}

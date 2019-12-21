package com.github.silencesu.behavior3java.composites;

import com.github.silencesu.behavior3java.constant.B3Const;
import com.github.silencesu.behavior3java.constant.B3Status;
import com.github.silencesu.behavior3java.core.Blackboard;
import com.github.silencesu.behavior3java.core.Tick;
import com.github.silencesu.behavior3java.core.Composite;

/**
 * 记忆顺序节点
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class MemSequence extends Composite {


    @Override
    public void onOpen(Tick tick) {

        Blackboard.Memory memory = tick.getBlackboard().getMemeory(tick.getTree().getId(), this.getId());
        memory.getMemeory().put(B3Const.RUNNING_CHILD, 0);
    }

    @Override
    public B3Status onTick(Tick tick) {

        Blackboard.Memory mm = tick.getBlackboard().getMemeory(tick.getTree().getId(), this.getId());

        int child = (int) mm.getMemeory().get(B3Const.RUNNING_CHILD);

        int childCount = getChildCount();

        for (int i = child; i < childCount; i++) {
            B3Status status = this.getChild(i).execute(tick);

            if (status != B3Status.SUCCESS) {
                if (status == B3Status.RUNNING) {
                    tick.getBlackboard().setParam(B3Const.RUNNING_CHILD, i, tick.getTree().getId(), this.getId());
                }
                return status;

            }

        }

        return B3Status.SUCCESS;
    }

}

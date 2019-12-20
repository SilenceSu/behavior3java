package org.behavior3.b3.composites;

import org.behavior3.b3.constant.B3Const;
import org.behavior3.b3.constant.B3Status;
import org.behavior3.b3.core.Blackboard;
import org.behavior3.b3.core.Tick;
import org.behavior3.b3.core.Composite;

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

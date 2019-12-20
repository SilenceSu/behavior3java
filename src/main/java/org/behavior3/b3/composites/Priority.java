package org.behavior3.b3.composites;

import org.behavior3.b3.constant.B3Status;
import org.behavior3.b3.core.Tick;
import org.behavior3.b3.core.Composite;

/**
 * 选择节点
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class Priority extends Composite {
    @Override
    public B3Status onTick(Tick tick) {
        for (int i = 0; i < this.getChildCount(); i++) {
            B3Status status = this.getChild(i).execute(tick);
            if (status != B3Status.FAILURE) {
                return status;
            }
        }
        return B3Status.FAILURE;
    }
}

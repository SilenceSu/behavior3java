package com.susu.b3.composites;

import com.susu.b3.constant.B3Status;
import com.susu.b3.core.Composite;
import com.susu.b3.core.Tick;

/**
 * 顺序节点
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class Sequence extends Composite {
    @Override
    public B3Status onTick(Tick tick) {
        for (int i = 0; i < this.getChildCount(); i++) {
            B3Status status = this.getChild(i).execute(tick);
            if (status != B3Status.SUCCESS) {
                return status;
            }

        }
        return B3Status.SUCCESS;
    }
}

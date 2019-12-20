package org.behavior3.b3.actions;

import org.behavior3.b3.constant.B3Status;
import org.behavior3.b3.core.Tick;
import org.behavior3.b3.core.Action;

/**
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class Runner extends Action {
    @Override
    public B3Status onTick(Tick tick) {
        return B3Status.SUCCESS;
    }
}

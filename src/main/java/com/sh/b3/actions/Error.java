package com.sh.b3.actions;

import com.sh.b3.constant.B3Status;
import com.sh.b3.core.Action;
import com.sh.b3.core.Tick;

/**
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class Error extends Action {

    @Override
    public B3Status onTick(Tick tick) {
        return B3Status.ERROR;
    }
}

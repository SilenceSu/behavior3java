package com.susu.b3.actions;

import com.susu.b3.constant.B3Status;
import com.susu.b3.core.Action;
import com.susu.b3.core.Tick;

/**
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class Failer extends Action {
    @Override
    public B3Status onTick(Tick tick) {
        return B3Status.FAILURE;
    }

}

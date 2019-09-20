package com.sh.b3.actions;

import com.sh.b3.config.BTNodeCfg;
import com.sh.b3.constant.B3Status;
import com.sh.b3.core.Action;
import com.sh.b3.core.Tick;
import lombok.extern.slf4j.Slf4j;

/**
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
@Slf4j
public class Log extends Action {
    private String info;


    @Override
    public void initialize(BTNodeCfg nodeCfg) {
        super.initialize(nodeCfg);
        info = nodeCfg.getProperties().get("info");
    }

    @Override
    public void onOpen(Tick tick) {
        super.onOpen(tick);
    }

    @Override
    public B3Status onTick(Tick tick) {
        log.info("action-log:{}", this.info);
        return B3Status.SUCCESS;
    }

}

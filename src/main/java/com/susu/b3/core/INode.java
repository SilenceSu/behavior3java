package com.susu.b3.core;

import com.susu.b3.config.BTNodeCfg;
import com.susu.b3.constant.B3Status;

/**
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public interface INode extends IBaseWrapper{


    void initialize(BTNodeCfg nodeCfg);

    String getCategory();

    B3Status execute(Tick tick);

    String getName();

    String getTitle();


}

package com.sh.b3.core;

import com.sh.b3.constant.B3Const;

/**
 * 行为节点  叶节点
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public abstract  class Action extends BaseNode  implements IAction {


    @Override
    public String getCategory() {
        return B3Const.ACTION;
    }

}

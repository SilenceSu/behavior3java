package com.github.silencesu.behavior3java.core;

import com.github.silencesu.behavior3java.constant.B3Const;
import com.github.silencesu.behavior3java.constant.B3Status;

/**
 * 行为节点 子树节点
 *
 * @author ming ming
 * @Email mingtingjian@sina.com Created by ming ming on 2020/1/7.
 */
public class SubTree extends Action {

    private BehaviorTree subTree;



    @Override
    public String getCategory() {
        return B3Const.ACTION;
    }

    @Override
    public B3Status onTick(Tick tick) {
        //子树可能没有加载上来，所以要延迟加载执行
        if (subTree == null) {
            subTree = projectInfo.findBTTreeById(getName());//此处name为子树的id
        }
        if (subTree == null) {
            return B3Status.ERROR;
        }
        return subTree.tick(tick.getTarget(), tick.getBlackboard());
    }

}

package com.susu.b3.core;

import com.susu.b3.constant.B3Const;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合节点
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public abstract class Composite extends BaseNode implements IComposite {

    private List<BaseNode> children = new ArrayList<>();

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public BaseNode getChild(int index) {
        return children.get(index);
    }


    @Override
    public void addChild(BaseNode baseNode) {
        children.add(baseNode);
    }

    @Override
    public String getCategory() {
        return B3Const.COMPOSITE;
    }

}

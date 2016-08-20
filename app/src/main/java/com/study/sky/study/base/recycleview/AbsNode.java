package com.study.sky.study.base.recycleview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/4/18.
 * function:
 */
public abstract class AbsNode {

    private Context context;

    protected ViewGroup container;

    public AbsNode(Context context) {
        this.context = context;
    }

    public View getContainerView(){
        return container;
    }

    public abstract View createView(View parent);
}

package com.study.sky.study.base.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/4/18.
 * function:
 */
public abstract class AbsNode {

    protected Context context;

    protected ViewGroup container;

    protected LayoutInflater inflater;

    public AbsNode(Context context, LayoutInflater inflater) {
        this.context = context;
        this.inflater = inflater;
    }

    public View getContainerView(){
        return container;
    }

    public abstract View onCreateView(View parent);
}

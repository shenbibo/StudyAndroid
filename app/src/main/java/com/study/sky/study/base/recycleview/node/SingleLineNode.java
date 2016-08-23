package com.study.sky.study.base.recycleview.node;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.sky.study.R;
import com.study.sky.study.base.recycleview.AbsNode;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/23.
 */
public class SingleLineNode extends AbsNode{

    public SingleLineNode(Context context, LayoutInflater inflater) {
        super(context, inflater);
    }

    @Override
    public View onCreateView(ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_singleline, parent, false);
        return root;
    }
}

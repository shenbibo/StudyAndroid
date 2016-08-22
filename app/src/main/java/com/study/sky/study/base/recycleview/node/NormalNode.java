package com.study.sky.study.base.recycleview.node;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.study.sky.study.R;
import com.study.sky.study.base.recycleview.AbsNode;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/23.
 */
public class NormalNode extends AbsNode {

    public NormalNode(Context context, LayoutInflater inflater){
        super(context, inflater);
    }

    @Override
    public View onCreateView(View parent) {
        View rootView = inflater.inflate(R.layout.item_normal_layout, null, false);
        return rootView;
    }
}

package com.study.sky.study.base.recycleview.model;

/**
 * Created by Administrator on 2016/4/18.
 * function: 纯粹数据类的基类
 */
public abstract class BaseBean {

    /**
     * RecycleView item的类型，用于在RecycleView.Adapter.getItemViewType(int position)方法中使用
     */
    public int type = 0;
}

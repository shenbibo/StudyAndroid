package com.study.sky.study.base.recycleview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.sky.study.base.recycleview.model.BaseBean;


/**
 * Created by Administrator on 2016/4/18.
 * function:
 */
public abstract class AbsView extends RecyclerView.ViewHolder {


    protected RecycleViewAdapter.OnItemClickListener listener;

    /**
     * viewHolder在RecylerView中的位置
     */
    protected int position;

//    protected BaseBean bean;

    protected Context context;

    /**
     * item的父布局容器
     * */
    protected ViewGroup parent;

    /**
     * 设置自定义的父布局容器
     * */
    protected void setParentContainer(ViewGroup parent){
        this.parent = parent;
    }

    /**
     * 子类实现该方法，加载界面布局
     * */
    protected abstract View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container);

    /**
     * 子类复写该方法初始化子控件，可以在{@link AbsView#onCreateView(LayoutInflater, ViewGroup )}中调用
     * */
    protected abstract void bindChildrenViews();

    /**
     * 如果子类复写该方法，请先调用super.initListeners().
     */
    protected void bindListeners() {
    }

    public AbsView(View itemView){
        super(itemView);
        this.context = itemView.getContext();
        bindChildrenViews();
    }

    /**
     * 设置整个item被点击的监听事件
     * */
    public void setOnItemClickListener(RecycleViewAdapter.OnItemClickListener listener) {
        this.listener = listener;
        setParentViewListeners();
    }

    protected void setParentViewListeners() {
        if (listener != null && itemView != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v, position);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onItemLongClick(v, position);
                    return true;
                }
            });
        }
    }

    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * <strong>子类复写该方法时，必须先调用其父类方法.  If they do not, an exception will be
     * thrown.</strong>
     */
    public boolean setData(BaseBean bean){
        boolean isRightBeanObject = bean.getClass() == ViewCreateFactory.getBeanClass(this.getClass());
        if(!isRightBeanObject){
            Class expectedClass =  ViewCreateFactory.getBeanClass(this.getClass());
            throw new RuntimeException("the bean is not match the itemView, bean = "
                    + bean.getClass().getSimpleName()
                    + ", itemView = " + this.getClass().getSimpleName()
                    + "expected bean = " + expectedClass.getSimpleName());
        }
//        this.bean = bean;
        return true;
    }



}

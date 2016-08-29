package com.study.sky.study.base.recycrleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by Administrator on 2016/4/18.
 * function:
 */
public abstract class AbsView extends RecyclerView.ViewHolder {


    protected RecyclerViewAdapter.OnItemClickListener listener;

//    /**
//     * viewHolder在RecylerView中的位置
//     */
//    protected int positionInData;

//    protected BaseBean bean;

    protected Context context;

//    /**
//     * item的父布局容器
//     * */
//    protected ViewGroup parent;
//
//    /**
//     * 设置自定义的父布局容器
//     * */
//    protected void setParentContainer(ViewGroup parent){
//        this.parent = parent;
//    }
//
//    /**
//     * 子类实现该方法，加载界面布局
//     * */
//    protected abstract View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container);

    /**
     * 子类复写该方法初始化子控件，可以在构造器中调用
     * */
    protected abstract void bindChildrenViews();

    /**
     * 如果子类复写该方法，请先调用super.initListeners().
     */
    protected void bindListeners() {
    }

    public AbsView(View itemContentView){
        super(itemContentView);
        this.context = itemContentView.getContext();
        bindChildrenViews();
    }

    /**
     * 设置整个item被点击的监听事件
     * */
    public void setOnItemClickListener(RecyclerViewAdapter.OnItemClickListener listener) {
        this.listener = listener;
        setParentViewListeners();
    }

    protected void setParentViewListeners() {
        if (listener != null && itemView != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //注意这里获取的item在Adapter中的位置采用的方法
                    //RecyclerView中的item是可以单独删除和插入的，所以item在Adapter中与对应数据在数据源列中的位置都是会变化的，
                    // 和其对应数据在数据源中的位置可能是对不上的。
                    listener.onItemClick(v, AbsView.this.getAdapterPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onItemLongClick(v,  AbsView.this.getAdapterPosition());
                    return true;
                }
            });
        }
    }

//    public void setPositionInData(int position) {
//        this.positionInData = position;
//    }

    /**
     * <strong>子类复写该方法时，必须先调用其父类方法.  If they do not, an exception will be
     * thrown.</strong>
     */
    public void setData(BaseBean bean){
        boolean isRightBeanObject = bean.getClass() == ViewCreateFactory.getBeanClass(this.getClass());
        if(!isRightBeanObject){
            Class expectedClass =  ViewCreateFactory.getBeanClass(this.getClass());
            throw new RuntimeException("the bean is not match the itemView, bean = "
                    + bean.getClass().getSimpleName()
                    + ", itemView = " + this.getClass().getSimpleName()
                    + "expected bean = " + expectedClass.getSimpleName());
        }
//        this.bean = bean;
    }



}

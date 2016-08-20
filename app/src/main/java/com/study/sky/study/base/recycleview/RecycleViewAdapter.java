package com.study.sky.study.base.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.study.sky.study.base.recycleview.provider.DataProvider;


/**
 * Created by Administrator on 2016/4/18.
 * function:
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<AbsView> {


    public interface OnItemClickListener {

        void onItemClick(View itemView, int position);

        void onItemLongClick(View itemView, int position);
    }

    private Context context;

    private DataProvider provider;

    private OnItemClickListener listener;

    public RecycleViewAdapter(Context context, DataProvider provider) {
        this.context = context;
        this.provider = provider;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public AbsView onCreateViewHolder(ViewGroup parent, int viewType) {
        //actual the parent view is RecyclerView, so do not use it
        BaseNode node = ViewCreateFactory.createNode(viewType, context);
        if (node != null) {
            View view = node.createView(node.getContainerView());
            //通过viewType创建对应的ViewHolder，它承担了绑定view，设置监听，设置数据的功能。
            AbsView holder = ViewCreateFactory.createItemView(view, viewType);
            if (holder != null) {
                return holder;
            }
        }
//        AbsView itemView = ViewCreateFactory.createItemView(viewType);
//        if (itemView != null) {
//            return itemView;
//        }
        return null;
    }

    @Override
    public void onBindViewHolder(AbsView holder, int position) {
        if (holder != null) {
            //设置holder的在列表中所表示的item的位置, 绑定数据源。
            holder.setPosition(position);
            holder.setOnItemClickListener(listener);
            holder.setData(provider.getBeanByPosition(position));
        }
    }

    @Override
    public int getItemCount() {
        return provider.getDataCount();
    }

    /**
     * 返回每个item对应的类型
     */
    @Override
    public int getItemViewType(int position) {
        return provider.getTypeByPosition(position);
    }
}

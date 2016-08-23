package com.study.sky.study.base.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.sky.study.base.recycleview.provider.DataProvider;

import java.util.List;


/**
 * Created by Administrator on 2016/4/18.
 * function:
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<AbsView> implements DataProvider.OnDataChangedListener {

    public interface OnItemClickListener {

        //        /**
        //         * 监听点击事件
        //         * {@link RecyclerView}中的item是可以单独删除和插入的，所以item在Adapter中的位置，和其对应数据在数据源中的位置可能是对不上的。
        //         *
        //         * @param itemView          被点击的item对应的View
        //         * @param positionInAdapter item对应的在Adapter中的位置
        //         * @param positionInData    该item对应的bean在数据源列表中的位置
        //         * @see RecycleViewAdapter#onBindViewHolder(AbsView, int)
        //         */
        //        void onItemClick(View itemView, int positionInAdapter, int positionInData);
        //
        //        /**
        //         * 监听item长按监听事件
        //         * {@link RecyclerView}中的item是可以单独删除和插入的，所以item在Adapter中的位置，和其对应数据在数据源中的位置可能是对不上的。
        //         *
        //         * @param itemView          被点击的item对应的View
        //         * @param positionInAdapter item对应的在Adapter中的位置
        //         * @param positionInData    该item对应的bean在数据源列表中的位置
        //         * @see RecycleViewAdapter#onBindViewHolder(AbsView, int)
        //         */
        //        void onItemLongClick(View itemView, int positionInAdapter, int positionInData);

        /**
         * 监听点击事件
         * @param itemView 被点击的item对应的View
         * @param position item对应的在Adapter/data中的位置
         * @see RecycleViewAdapter#onBindViewHolder(AbsView, int)
         */
        void onItemClick(View itemView, int position);

        /**
         * 监听item长按监听事件
         * @param itemView 被点击的item对应的View
         * @param position item对应的在Adapter/data中的位置
         * @see RecycleViewAdapter#onBindViewHolder(AbsView, int)
         */
        void onItemLongClick(View itemView, int position);
    }

    private Context context;

    private DataProvider provider;

    private OnItemClickListener listener;

    private LayoutInflater inflater;

//    private List<DataProvider.BeanWrapper> beans;

    public RecycleViewAdapter(Context context, DataProvider provider) {
        this.context = context;
        this.provider = provider;
//        beans = provider.getData();
        inflater = LayoutInflater.from(context);
        this.provider.setDataChangedListener(this);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public AbsView onCreateViewHolder(ViewGroup parent, int viewType) {
        //actual the parent view is RecyclerView, so do not use it
        AbsNode node = ViewCreateFactory.createNode(viewType, context, inflater);
        if (node != null) {
            node.setParentView(parent);
            View view = node.onCreateView(node.getContainerView());
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
            //设置全局监听事件, 绑定数据源，该position的位置不能保存具体看该方法的注释
            holder.setOnItemClickListener(listener);
            holder.setData(provider.getBeanByPosition(position));
        }
    }

    @Override
    public void onBindViewHolder(AbsView holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
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

    @Override
    public void notifyDataChanged() {
//        beans = provider.getData();
        notifyDataSetChanged();
//        notifyItemChanged(0);
//        notifyItemChanged(0, null);
//        notifyItemRangeChanged(0, 2, null);
//        notifyItemInserted(0);
//        notifyItemMoved(0, 1);
//        notifyItemRemoved(0);
//        notifyItemRangeChanged(0, 1);
//        notifyItemRangeChanged(0, 2, null);
//        notifyItemRangeInserted(0, 2);
//        notifyItemRangeRemoved(0, 2);
    }
}

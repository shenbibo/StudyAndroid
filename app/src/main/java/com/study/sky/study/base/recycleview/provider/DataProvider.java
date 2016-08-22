package com.study.sky.study.base.recycleview.provider;


import com.study.sky.study.base.recycleview.ViewCreateFactory;
import com.study.sky.study.base.recycleview.BaseBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * 将单个数据组织成一个数据源传递给Adapter<p>
 * Created by Administrator on 2016/4/18.
 */
public class DataProvider {


    /**
     * 通知数据发生改变接口
     */
    public interface OnDataChangedListener {

        /**
         * 通知数据发生改变
         */
        void notifyDataChanged();
    }

    private CopyOnWriteArrayList<BeanWrapper> beans = new CopyOnWriteArrayList<>();

    private OnDataChangedListener listener;

    public int getDataCount() {
        return beans.size();
    }

    public BaseBean getBeanByPosition(int position) {
        return beans.get(position).bean;
    }

    public int getTypeByPosition(int position) {
        return beans.get(position).viewType;
    }

    /**
     * 设置数据改变监听器
     */
    public void setDataChangedListener(OnDataChangedListener listener) {
        this.listener = listener;
    }

    /**
     * @param beanList 要传入的数据源列表
     * @param viewType 上面传入的数据源的类型
     *                 调用该方法时，必须保证所有的{@code beanList}中的{@code bean}所对应的是同一个{@code viewType}。
     */
    public void updateProvider(List<? extends BaseBean> beanList, String viewType) {
        ArrayList<BeanWrapper> beanWrappers = new ArrayList<>();
        for (BaseBean bean : beanList) {
            beanWrappers.add(new BeanWrapper(bean, viewType));
        }
        beans.addAll(beanWrappers);
    }

    public void updateProvider(BaseBean bean, String viewType) {
        this.beans.add(new BeanWrapper(bean, viewType));
    }

    /**
     * @param beanArray 要传入的数据源数组
     * @param viewType  上面传入的数据源的类型
     *                  调用该方法时，必须保证所有的{@code beanList}中的{@code bean}所对应的是同一个{@code viewType}。
     */
    public void updateProvider(BaseBean[] beanArray, String viewType) {
        ArrayList<BeanWrapper> beanWrappers = new ArrayList<>();
        for (BaseBean bean : beanArray) {
            beanWrappers.add(new BeanWrapper(bean, viewType));
        }
        beans.addAll(beanWrappers);
    }


    //    /**
    //     * 返回数据列表
    //     */
    //    public List<BeanWrapper> getData() {
    //        List<BeanWrapper> data = new ArrayList<>();
    //        synchronized (this) {
    //            data.addAll(beans);
    //            return data;
    //        }
    //    }

    /**
     * 删除给定下标的数据
     */
    public BeanWrapper remove(int position) {
        return beans.remove(position);
    }

    public void clear() {
        beans.clear();
    }


    public void notifyDataChanged() {
        if (listener != null) {
            listener.notifyDataChanged();
        }
    }

    public static class BeanWrapper {
        public BaseBean bean;
        public int viewType;

        public BeanWrapper(BaseBean baseBean, String viewType) {
            bean = baseBean;
            this.viewType = ViewCreateFactory.getType(viewType);
        }
    }
}

package com.study.sky.study.base.recycleview.provider;


import com.study.sky.study.base.recycleview.ViewCreateFactory;
import com.study.sky.study.base.recycleview.model.BaseBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/4/18.
 * function: 将单个数据组织成一个数据源传递给Adapter
 */
public class DataProvider {

    private List<BaseBean> beans = new ArrayList<>();

    public int getDataCount() {
        return 0;
    }

    public BaseBean getBeanByPosition(int position) {
        return beans.get(position);
    }

    public int getTypeByPosition(int position) {
        return ViewCreateFactory.getViewTypeByBean(beans.get(position).getClass());
    }

    public void updateProvider(List<BaseBean> beanList) {
        this.beans.addAll(beanList);
    }

    public void updateProvider(BaseBean bean) {
        this.beans.add(bean);
    }

    public void updateProvider(BaseBean[] beanArray) {
        for (BaseBean bean : beanArray) {
            this.beans.add(bean);
        }
    }

    public void clear() {
        this.beans.clear();
    }
}

package com.study.sky.study.modules.main.presenter;

import com.study.sky.study.base.recycleview.ViewDefine;
import com.study.sky.study.common.provider.DataProvider;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/16.
 */
public class MainPresenterImpl implements MainContract.MainPresenter{

    private MainContract.MainView view;

    private DataProvider provider;

    public MainPresenterImpl(MainContract.MainView view){
        this.view = view;
    }

    @Override
    public DataProvider getDataProvider() {
        if(provider == null){
            provider = new DataProvider();
            provider.updateProvider(ItemBeanInjection.createNormalBean(), ViewDefine.NORMAL_VIEW);
        }
        return provider;
    }
}

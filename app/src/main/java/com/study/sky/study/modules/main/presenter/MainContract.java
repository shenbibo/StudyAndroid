package com.study.sky.study.modules.main.presenter;

import com.study.sky.study.base.BasePresenter;
import com.study.sky.study.base.BaseInterfaceView;
import com.study.sky.study.base.recycleview.provider.DataProvider;


/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/16.
 */
public class MainContract {

    public interface MainPresenter extends BasePresenter {

        DataProvider getDataProvider();

    }

    public interface MainView extends BaseInterfaceView {

    }
}

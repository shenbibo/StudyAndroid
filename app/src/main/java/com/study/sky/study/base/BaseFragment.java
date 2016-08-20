package com.study.sky.study.base;

import android.support.v4.app.Fragment;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/7.
 */
public abstract class BaseFragment extends Fragment {

    protected abstract void initViews();

    protected abstract void initValues();

    protected abstract void initListeners();
}

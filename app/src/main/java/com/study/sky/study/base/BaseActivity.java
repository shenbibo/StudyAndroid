package com.study.sky.study.base;

import android.support.v7.app.AppCompatActivity;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/7.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void initViews();

    protected abstract void initValues();

    protected abstract void initListeners();
}

package com.study.sky.study.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.study.sky.study.base.recycleview.ItemViewInit;

/**
 * Created by sky on 2016/8/7.
 */
public class StudyApplication extends Application{

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.i(this.getClass().getSimpleName(), "init startTime = " + System.currentTimeMillis());
        ItemViewInit.init();
        Log.i(this.getClass().getSimpleName(), "init finishTime = " + System.currentTimeMillis());
    }
}

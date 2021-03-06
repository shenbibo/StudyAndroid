package com.study.sky.study.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.study.sky.study.base.recycrleview.ViewDefine;

/**
 * Created by sky on 2016/8/7.
 */
public class StudyApplication extends Application{

    private static StudyApplication instance;



    @Override
    protected void attachBaseContext(Context base) {
        instance = this;
        super.attachBaseContext(base);
        Log.i(this.getClass().getSimpleName(), "init startTime = " + System.currentTimeMillis());
        ViewDefine.init();
        Log.i(this.getClass().getSimpleName(), "init finishTime = " + System.currentTimeMillis());
    }

    public static StudyApplication getApplication(){
        return instance;
    }
}

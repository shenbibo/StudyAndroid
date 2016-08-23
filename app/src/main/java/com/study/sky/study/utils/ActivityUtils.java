package com.study.sky.study.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/16.
 */
public final class ActivityUtils {

    /**
     * 添加Fragment，如果对应ID已存在fragment则替换
     */
    public static void addFragment(FragmentManager fm, Fragment fragment, int containerId) {
        Fragment tempFragment = fm.findFragmentById(containerId);
        FragmentTransaction ft = fm.beginTransaction();
        if (tempFragment != null) {
            ft.replace(containerId, fragment);
        } else {
            ft.add(containerId, fragment);
        }
        ft.commitAllowingStateLoss();
    }
}

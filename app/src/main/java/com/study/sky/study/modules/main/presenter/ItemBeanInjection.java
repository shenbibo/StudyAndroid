package com.study.sky.study.modules.main.presenter;

import com.study.sky.study.common.beans.NormalBean;

import java.util.ArrayList;
import java.util.List;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/23.
 */
public class ItemBeanInjection {

    public static List<NormalBean> createNormalBean(){
        List<NormalBean> beans = new ArrayList<>();
        for(int i =0; i < 20; i++){
            NormalBean bean = new NormalBean();
            bean.title = i + "---akjsjgg";
            bean.content = i + "---hjakjslg";
            beans.add(bean);
        }
        return beans;
    }
}

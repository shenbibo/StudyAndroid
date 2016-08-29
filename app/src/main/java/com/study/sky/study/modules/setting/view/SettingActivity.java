package com.study.sky.study.modules.setting.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.study.sky.study.R;
import com.study.sky.study.base.BaseActivity;
import com.study.sky.study.base.recycrleview.RecyclerViewAdapter;
import com.study.sky.study.base.recycrleview.ViewDefine;
import com.study.sky.study.common.beans.SingleLineBean;
import com.study.sky.study.common.provider.DataProvider;
import com.study.sky.study.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置类
 * [详述类的功能。]
 * Created by sky on 2016/8/23.
 */
public class SettingActivity extends BaseActivity {

    private RecyclerView settingList;

    private DataProvider settingProvider;

    private RecyclerViewAdapter adapter;

    private String[] itemStrings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initViews();
        initValues();
        initListeners();
    }

    @Override
    protected void initViews() {
        initRecyclerView();
    }

    @Override
    protected void initValues() {

    }

    @Override
    protected void initListeners() {
        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                String itemName = ((SingleLineBean) settingProvider.getBeanByPosition(position)).name;
                if(itemStrings[0].equals(itemName)){
                    ActivityUtils.startActivity(SettingActivity.this, AboutActivity.class);
                }
            }

            @Override
            public void onItemLongClick(View itemView, int position) {

            }
        });
    }

    private void initRecyclerView() {
        settingList = (RecyclerView) findViewById(R.id.setting_list);
        settingList.setLayoutManager(new LinearLayoutManager(this));
        initDataProvider();
        adapter = new RecyclerViewAdapter(this, settingProvider);
        settingList.setAdapter(adapter);
    }

    private void initDataProvider() {
        settingProvider = new DataProvider();
        itemStrings = getResources().getStringArray(R.array.setting_item_title);
        List<SingleLineBean> beans = new ArrayList<>();
        for (String title : itemStrings) {
            SingleLineBean bean = new SingleLineBean();
            bean.name = title;
            beans.add(bean);
        }
        settingProvider.updateProvider(beans, ViewDefine.SINGLE_LINE_VIEW);
    }
}

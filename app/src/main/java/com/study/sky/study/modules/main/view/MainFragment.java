package com.study.sky.study.modules.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.sky.study.R;
import com.study.sky.study.base.BaseFragment;
import com.study.sky.study.base.recycleview.RecycleViewAdapter;
import com.study.sky.study.modules.main.presenter.MainContract;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/16.
 */
public class MainFragment extends BaseFragment implements MainContract.MainView {

    private MainContract.MainPresenter presenter;

    private RecycleViewAdapter rvAdapter;

    /**
     * 放置主数据
     */
    private RecyclerView mainList;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        initRecycleView(root);
        return root;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initValues() {

    }

    @Override
    protected void initListeners() {

    }

    /**
     * 初始化recycleView
     */
    private void initRecycleView(View root){
        mainList = (RecyclerView) root.findViewById(R.id.main_list);
        mainList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAdapter = new RecycleViewAdapter(getActivity(), presenter.getDataProvider());
        mainList.setAdapter(rvAdapter);

    }

    public void setPresenter(MainContract.MainPresenter presenter) {
        this.presenter = presenter;
    }
}
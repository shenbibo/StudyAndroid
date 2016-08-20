package com.study.sky.study.modules.main.view;

import android.content.Intent;
import android.os.Bundle;

import com.study.sky.study.base.BaseActivity;

public class PreActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainActivity2.class));
        finish();
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
}

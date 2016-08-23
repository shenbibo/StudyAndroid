package com.study.sky.study.modules.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.study.sky.study.R;
import com.study.sky.study.base.BaseActivity;
import com.study.sky.study.modules.main.presenter.MainPresenterImpl;
import com.study.sky.study.modules.setting.view.SettingActivity;
import com.study.sky.study.utils.ActivityUtils;

/**
 * 主Activity
 * [详述类的功能。]
 * Created by sky on 2016/8/11.
 */
public class MainActivity2 extends BaseActivity {

    /**
     * 父容器
     */
    private DrawerLayout drawerLayout;

    /**
     *
     * */
    private CoordinatorLayout coordinatorLayout;

    /**
     * 导航栏
     */
    private Toolbar toolbar;

    /**
     * 侧边菜单栏
     */
    private NavigationView navigationView;

    /**
     * 放置Fragment的容器
     */
    private RelativeLayout container;

    /**
     * 悬浮button
     */
    private FloatingActionButton addfab;

    /**
     * 给NavigationView绑定监听事件
     */
    private ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
        initValues();
        initListeners();
    }

    @Override
    protected void initViews() {
        //init toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);

        //init navigationView
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        //init container
        container = (RelativeLayout) findViewById(R.id.container);

        addfab = (FloatingActionButton) findViewById(R.id.fab);

        ////test_code///////////
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_list);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        DataProvider provider = new DataProvider();
//        provider.updateProvider(ItemBeanInjection.createNormalBean(), ItemViewInit.NORMAL_VIEW);
//        RecycleViewAdapter adapter = new RecycleViewAdapter(this, provider);
//        recyclerView.setAdapter(adapter);

        /////////test_end/////////

        //init Fragment
        MainFragment fragment = MainFragment.newInstance();

        //init presenter
        MainPresenterImpl presenter = new MainPresenterImpl(fragment);

        fragment.setPresenter(presenter);
        ActivityUtils.addFragment(getSupportFragmentManager(), fragment, R.id.container);

    }

    @Override
    protected void initValues() {
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        //当设置了以下被注释掉的代码时，下面的icon设置不生效
//        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
//        drawerLayout.addDrawerListener(toggle);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void initListeners() {
        //如果使用以下代码给toolbar的home键设置监听，则打开侧边栏菜单显示为箭头，关闭显示为三条横线
        //而且不需要在onOptionsItemSelected方法中监听home键
//        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
//        drawerLayout.addDrawerListener(toggle);
        setNavigationViewListener(navigationView);
        addfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //只有放在coordinatorlayout中才会让flatbutton自动上移
                Snackbar.make(coordinatorLayout, "SnackBar Test!!", Snackbar.LENGTH_LONG).show();
            }
        });
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
//        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setNavigationViewListener(NavigationView view) {
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.main_setting_menu_item){
                    ActivityUtils.startActivity(MainActivity2.this, SettingActivity.class);
                }
                return false;
            }
        });
    }
}

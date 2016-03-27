package com.summersama.pma;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends Activity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    //底部菜单的4个LinearLayout
    private LinearLayout ll_home;
    private LinearLayout ll_cAll;
    private LinearLayout ll_add;
    private LinearLayout ll_query;

    //底部菜单的4个ImageView
    private ImageView iv_home;
    private ImageView iv_cAll;
    private ImageView iv_add;
    private ImageView iv_query;

    //底部菜单的4个标题
    private TextView tv_home;
    private TextView tv_cAll;
    private TextView tv_add;
    private TextView tv_query;

    //中间内容区域
    private ViewPager viewPager;

    //ViewPager适配器 AndriodIndexPagerAdpater
    private AndriodIndexPageAdapter adapter;

    private List<View> views;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        //初始化控件
        initView();
        //初始化底部按钮事件
        initEvent();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    private void initEvent() {
        //设置按钮监听
        ll_home.setOnClickListener(this);
        ll_cAll.setOnClickListener(this);
        ll_add.setOnClickListener(this);
        ll_query.setOnClickListener(this);

        //设置ViewPager滑动监听
        viewPager.setOnPageChangeListener(this);
    }

    private void initView() {
        this.ll_home = (LinearLayout) findViewById(R.id.ll_home);
        this.ll_cAll = (LinearLayout) findViewById(R.id.ll_cAll);
        this.ll_add = (LinearLayout) findViewById(R.id.ll_add);
        this.ll_query = (LinearLayout) findViewById(R.id.ll_query);

        this.iv_home = (ImageView) findViewById(R.id.iv_home);
        this.iv_cAll = (ImageView) findViewById(R.id.iv_cAll);
        this.iv_add = (ImageView) findViewById(R.id.iv_add);
        this.iv_query = (ImageView) findViewById(R.id.iv_query);

        this.tv_home = (TextView) findViewById(R.id.tv_home);
        this.tv_cAll = (TextView) findViewById(R.id.tv_cAll);
        this.tv_add = (TextView) findViewById(R.id.tv_add);
        this.tv_query = (TextView) findViewById(R.id.tv_query);

        this.viewPager = (ViewPager) findViewById(R.id.vp_content);

        //适配器

        View page_1 = View.inflate(IndexActivity.this,R.layout.android_index_page_1,null);
        View page_2 = View.inflate(IndexActivity.this,R.layout.android_index_page_2,null);
        View page_3 = View.inflate(IndexActivity.this,R.layout.android_index_page_3,null);
        View page_4 = View.inflate(IndexActivity.this,R.layout.android_index_page_4,null);


        views = new ArrayList<View>();
        views.add(page_1);
        views.add(page_2);
        views.add(page_3);
        views.add(page_4);


        this.adapter = new AndriodIndexPageAdapter(views);
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
               restartBotton();
                 // ImageView和TetxView置为绿色，页面随之跳转
                switch (v.getId()) {
                    case R.id.ll_home:
                            //iv_home.setImageResource(R.drawable.tab_weixin_pressed);
                            tv_home.setTextColor(0xff1B940A);
                            viewPager.setCurrentItem(0);
                    break;
                   case R.id.ll_cAll:
                           // iv_cAll.setImageResource(R.drawable.tab_address_pressed);
                           tv_cAll.setTextColor(0xff1B940A);
                            viewPager.setCurrentItem(1);
                            break;
                    case R.id.ll_add:
                            //iv_add.setImageResource(R.drawable.tab_find_frd_pressed);
                          tv_add.setTextColor(0xff1B940A);
                          viewPager.setCurrentItem(2);
                           break;
                    case R.id.ll_query:
                         //  iv_query.setImageResource(R.drawable.tab_find_frd_pressed);
                           tv_query.setTextColor(0xff1B940A);
                           viewPager.setCurrentItem(3);
                            break;

                    default:
                             break;
                   }

    }

    private void restartBotton() {
        // ImageView置为灰色
                // iv_home.setImageResource(R.drawable.tab_weixin_normal);
              //  iv_cAll.setImageResource(R.drawable.tab_address_normal);
              //  iv_add.setImageResource(R.drawable.tab_find_frd_normal);
             //   iv_query.setImageResource(R.drawable.tab_settings_normal);
                 // TextView置为白色
                 tv_home.setTextColor(0xffffffff);
                tv_cAll.setTextColor(0xffffffff);
                 tv_add.setTextColor(0xffffffff);
                 tv_query.setTextColor(0xffffffff);

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
                 restartBotton();
                 //当前view被选择的时候,改变底部菜单图片，文字颜色
                 switch (arg0) {
                     case 0:
                          //   iv_home.setImageResource(R.drawable.tab_weixin_pressed);
                             tv_home.setTextColor(0xff1B940A);
                             break;
                     case 1:
                            // iv_cAll.setImageResource(R.drawable.tab_address_pressed);
                             tv_cAll.setTextColor(0xff1B940A);
                             break;
                     case 2:
                          //   iv_add.setImageResource(R.drawable.tab_find_frd_pressed);
                tv_add.setTextColor(0xff1B940A);
                            break;
                    case 3:
                         //  iv_query.setImageResource(R.drawable.tab_find_frd_pressed);
                          tv_query.setTextColor(0xff1B940A);
                            break;

                    default:
                            break;
                   }

            }


    @Override
    public void onPageScrollStateChanged(int arg0) {

    }


}

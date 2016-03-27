package com.summersama.pma;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by woshi on 2016/3/27.
 */
public class AndriodIndexPageAdapter extends PagerAdapter {
    private List<View> views;
    public AndriodIndexPageAdapter(List<View> views){
        this.views = views;
    }
    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }
    @Override
    public Object instantiateItem(ViewGroup container,int position){
        View view = views.get(position);
        container.addView(view);
        return  view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }
}

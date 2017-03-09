package com.example.lenovo.numbertwoapp.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/2/28.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>list;
    private ArrayList<String>list1;
    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment>list,ArrayList<String>list1) {
        super(fm);
        this.list=list;
        this.list1=list1;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {


        return list1.get(position);
    }
}

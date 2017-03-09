package com.example.lenovo.numbertwoapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.adpter.ViewPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/2/27.
 */

public class Fragment1 extends Fragment {
    private ViewPager viewPager_home;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1,null);
        viewPager_home= (ViewPager) view.findViewById(R.id.home_vp);
        tabLayout= (TabLayout) view.findViewById(R.id.table);
        viewPagerAdapter=new ViewPagerAdapter(getFragmentManager(),getDta(),getTitle());
        viewPager_home.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager_home);
        return view;}
    public ArrayList<Fragment>getDta(){
           ArrayList<Fragment>list=new ArrayList<>();
           Fragment fragment;
           Bundle bundle;
        for (int i=0;i<getTitle().size();i++){
            fragment=new FragmentItem();
            bundle=new Bundle();
            bundle.putString("path",getType().get(i));
            fragment.setArguments(bundle);
            list.add(fragment);}return list;}
    public ArrayList<String>getTitle(){
        ArrayList<String>list1=new ArrayList<>();
        list1.add("头条");
        list1.add("社会");
        list1.add("国内");
        list1.add("国际");
        list1.add("娱乐");
        list1.add("体育");
        list1.add("军事");
        list1.add("科技");
        list1.add("财经");
        list1.add("时尚");
        return list1;}
    public ArrayList<String>getType(){
        ArrayList<String>list1=new ArrayList<>();
        list1.add("top");
        list1.add("shehui");
        list1.add("guonei");
        list1.add("guoji");
        list1.add("yule");
        list1.add("tiyu");
        list1.add("junshi");
        list1.add("keji");
        list1.add("caijing");
        list1.add("shishang");
        return list1;}
}

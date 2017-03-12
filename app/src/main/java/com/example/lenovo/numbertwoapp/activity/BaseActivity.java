package com.example.lenovo.numbertwoapp.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

import com.example.lenovo.numbertwoapp.R;

/**
 * Created by lenovo on 2017/2/4.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
       // Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
        //退出时使用
      //  getWindow().setExitTransition(explode);
//第一次进入时使用
       // getWindow().setEnterTransition(explode);
//再次进入时使用
       // getWindow().setReenterTransition(explode);
        addLayout();
        initView();

    }
    //加载布局的方法
    public abstract  void addLayout();
    //findviewbyid控件初始化方法
    public abstract void initView();


    public void gotoactivity1(Class<?> activity){
        Intent intent=new Intent(this,activity);
        startActivity(intent);

    }
    public void gotoactivity(Class<?> activity){
        Intent intent=new Intent(this,activity);
        startActivity(intent);
        finish();
    }
    public void gotoactivity(Class<?> activity,String s,String value){
        Intent intent=new Intent(this,activity);
        intent.putExtra(s,value);
        startActivity(intent);
        finish();
    }
    public void gotoactivity(Class<?> activity,boolean b){
        Intent intent=new Intent(this,activity);
        startActivity(intent);
        if (b){
            finish();
        }
    }
}

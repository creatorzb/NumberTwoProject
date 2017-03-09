package com.example.lenovo.numbertwoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lenovo on 2017/2/4.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

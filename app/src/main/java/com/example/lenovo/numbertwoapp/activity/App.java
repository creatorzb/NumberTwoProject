package com.example.lenovo.numbertwoapp.activity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;

import cn.jpush.android.api.JPushInterface;


public class App extends Application {



    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        {

            PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
            PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
            PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
        }
    }}

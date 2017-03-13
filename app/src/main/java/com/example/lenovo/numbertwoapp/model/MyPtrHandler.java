package com.example.lenovo.numbertwoapp.model;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.numbertwoapp.R;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by lenovo on 2017/3/13.
 */
public class MyPtrHandler implements PtrUIHandler {
    private Context context;

    private ImageView img;
    private TextView tip;

    public MyPtrHandler(Context context, ViewGroup parent) {
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.view_ptrrefresher, parent);
        this.img = (ImageView) view.findViewById(R.id.id_header_iv_img);
        this.tip = (TextView) view.findViewById(R.id.id_header_tv_tip);
    }
    @Override
    public void onUIReset(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        tip.setText("下拉刷新");
    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        tip.setText("加载中......");
        RotateAnimation animation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f,RotateAnimation.RELATIVE_TO_SELF, 0.5f
        );
        animation.setFillAfter(false);
        animation.setDuration(1000);
        animation.setRepeatMode(Animation.RESTART);
        img.startAnimation(animation);
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame, boolean isHeader) {
        tip.setText("加载完成    ");
        Toast.makeText(context, "加载成功!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {

    }
}

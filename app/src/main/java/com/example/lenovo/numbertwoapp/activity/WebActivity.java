package com.example.lenovo.numbertwoapp.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.mc.LoLView_C;
import com.example.lenovo.numbertwoapp.model.Person;
import com.umeng.social.tool.UMImageMark;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import static android.R.attr.bottom;
import static android.R.attr.left;
import static android.R.attr.right;
import static android.R.attr.top;

/**
 * Created by lenovo on 2017/3/5.
 */

public class WebActivity extends BaseActivity {
    private WebView webView;
    private ImageView imageView_ysc, imageView_nosc;
    private LoLView_C loLView_c;
    private String url, name, image;
    private Person person;
    private ImageView imageView_back, imageView_fx;

    @Override
    public void addLayout() {
        setContentView(R.layout.web_layout);

    }

    @Override
    public void initView() {
        webView = (WebView) findViewById(R.id.webview);
        imageView_ysc = (ImageView) findViewById(R.id.imageView_yishoucang);
        imageView_nosc = (ImageView) findViewById(R.id.imageView_weishoucang);
        imageView_back = (ImageView) findViewById(R.id.imageview_webback);
        imageView_fx = (ImageView) findViewById(R.id.fenxiang);
        loLView_c = new LoLView_C(this);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        name = intent.getStringExtra("name");
        image = intent.getStringExtra("image");


        person = new Person(url, name, image);
        Log.e("111",person.getName()+person.getImage()+person.getUrl());
        if (loLView_c.saixuan(person,loLView_c.showAll()) == true) {
            imageView_nosc.setVisibility(View.INVISIBLE);
            imageView_ysc.setVisibility(View.VISIBLE);
        }else {
            imageView_nosc.setVisibility(View.VISIBLE);
            imageView_ysc.setVisibility(View.INVISIBLE);
        }
        webView.loadUrl(url);
        imageView_ysc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView_ysc.setVisibility(View.INVISIBLE);
                imageView_nosc.setVisibility(View.VISIBLE);
                loLView_c.delete(person,loLView_c.showAll());
                Toast.makeText(WebActivity.this, "取消收藏！", Toast.LENGTH_SHORT).show();


            }
        });
        imageView_nosc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView_nosc.setVisibility(View.INVISIBLE);
                imageView_ysc.setVisibility(View.VISIBLE);
                loLView_c.add(person, loLView_c.showAll());
                Toast.makeText(WebActivity.this, "收藏成功！", Toast.LENGTH_SHORT).show();


            }
        });
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WebActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        UMImage thumb =  new UMImage(this, image);
        UMImageMark umImageMark = new UMImageMark();
        umImageMark.setGravity(Gravity.BOTTOM | Gravity.RIGHT);
        umImageMark.setMarkBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.logo));
        umImageMark.setAlpha(00);//设置透明度
        umImageMark.setMargins(left,top,right,bottom);//设置边距
        final UMImage imagelocal = new UMImage(this,R.drawable.logo,umImageMark);
        final UMWeb web = new UMWeb(url);
        web.setTitle(name);//标题
        web.setThumb(thumb);  //缩略图
        web.setDescription("");//
        imageView_fx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShareAction(WebActivity.this).withMedia(web)
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ,SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
            }
        });
    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);

            Toast.makeText(WebActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            Toast.makeText(WebActivity.this, share_media + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if (throwable != null) {
                Log.d("throw", "throw:" + throwable.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {

        }
    };}
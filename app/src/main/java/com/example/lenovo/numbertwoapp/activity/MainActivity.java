package com.example.lenovo.numbertwoapp.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.fragments.Fragment1;
import com.example.lenovo.numbertwoapp.fragments.Fragment2;
import com.example.lenovo.numbertwoapp.fragments.Fragment3;
import com.example.lenovo.numbertwoapp.fragments.Fragment4;
import com.example.lenovo.numbertwoapp.fragments.Fragment5;


public class MainActivity extends BaseActivity {
     private static int p=0;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private RelativeLayout relativeLayout_home,relativeLayout_hot,
    relativeLayout_vip,relativeLayout_live,relativeLayout_person;
    private Fragment []fragments=new Fragment[5];
    private int count;
    private ImageView imageView_home01,imageView_home02,
    imageView_hot01,imageView_hot02,imageView_vip01,imageView_vip02,
    imageView_live01,imageView_live02,imageView_person01,imageView_person02;
    private TextView textView_home, textView_vip,textView_hot,
    textView_live,textView_person;
    @Override
    public void addLayout() {setContentView(R.layout.activity_main);


        }
    @Override
    public void initView() {
        relativeLayout_home= (RelativeLayout) findViewById(R.id.home_rl);
        relativeLayout_hot= (RelativeLayout) findViewById(R.id.hot_rl);
        relativeLayout_live= (RelativeLayout) findViewById(R.id.live_rl);
        relativeLayout_vip= (RelativeLayout) findViewById(R.id.vip_rl);
        relativeLayout_person= (RelativeLayout) findViewById(R.id.person_rl);
        imageView_home01= (ImageView) findViewById(R.id.home_normal);
        imageView_home02= (ImageView) findViewById(R.id.home_notnormal);
        imageView_hot01= (ImageView) findViewById(R.id.hot_normal);
        imageView_hot02= (ImageView) findViewById(R.id.hot_notnormal);
        imageView_vip01= (ImageView) findViewById(R.id.vip_normal);
        imageView_vip02= (ImageView) findViewById(R.id.vip_notnormal);
        imageView_live01= (ImageView) findViewById(R.id.live_normal);
        imageView_live02= (ImageView) findViewById(R.id.live_notnormal);
        imageView_person01= (ImageView) findViewById(R.id.person_normal);
        imageView_person02= (ImageView) findViewById(R.id.person_notnormal);
        textView_home= (TextView) findViewById(R.id.tv_home);
        textView_hot= (TextView) findViewById(R.id.tv_hot);
        textView_live= (TextView) findViewById(R.id.tv_live);
        textView_vip= (TextView) findViewById(R.id.tv_vip);
        textView_person= (TextView) findViewById(R.id.tv_person);
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        fragments[0]=new Fragment1();
        ft.add(R.id.main_layout,fragments[0]);
        ft.commit();
        count=0;
        Clicklistener();
    }
    public void Clicklistener(){
        relativeLayout_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_home.setTextColor(0xfffa7500);
                textView_person.setTextColor(0xff000000);
                textView_hot.setTextColor(0xff000000);
                textView_vip.setTextColor(0xff000000);
                textView_live.setTextColor(0xff000000);
                imageView_home01.setVisibility(View.INVISIBLE);
                imageView_home02.setVisibility(View.VISIBLE);
                imageView_hot02.setVisibility(View.INVISIBLE);
                imageView_hot01.setVisibility(View.VISIBLE);
                imageView_vip02.setVisibility(View.INVISIBLE);
                imageView_vip01.setVisibility(View.VISIBLE);
                imageView_live02.setVisibility(View.INVISIBLE);
                imageView_live01.setVisibility(View.VISIBLE);
                imageView_person02.setVisibility(View.INVISIBLE);
                imageView_person01.setVisibility(View.VISIBLE);
                   choiceFragment(0);
            }});
        relativeLayout_hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_hot.setTextColor(0xfffa7500);
                textView_person.setTextColor(0xff000000);
                textView_home.setTextColor(0xff000000);
                textView_vip.setTextColor(0xff000000);
                textView_live.setTextColor(0xff000000);
                imageView_hot01.setVisibility(View.INVISIBLE);
                imageView_hot02.setVisibility(View.VISIBLE);
                imageView_vip02.setVisibility(View.INVISIBLE);
                imageView_vip01.setVisibility(View.VISIBLE);
                imageView_live02.setVisibility(View.INVISIBLE);
                imageView_live01.setVisibility(View.VISIBLE);
                imageView_person02.setVisibility(View.INVISIBLE);
                imageView_person01.setVisibility(View.VISIBLE);
                imageView_home02.setVisibility(View.INVISIBLE);
                imageView_home01.setVisibility(View.VISIBLE);
                choiceFragment(1);
            }});
        relativeLayout_vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_vip.setTextColor(0xfffa7500);
                textView_person.setTextColor(0xff000000);
                textView_hot.setTextColor(0xff000000);
                textView_home.setTextColor(0xff000000);
                textView_live.setTextColor(0xff000000);
                imageView_vip01.setVisibility(View.INVISIBLE);
                imageView_vip02.setVisibility(View.VISIBLE);
                imageView_hot02.setVisibility(View.INVISIBLE);
                imageView_hot01.setVisibility(View.VISIBLE);
                imageView_live02.setVisibility(View.INVISIBLE);
                imageView_live01.setVisibility(View.VISIBLE);
                imageView_person02.setVisibility(View.INVISIBLE);
                imageView_person01.setVisibility(View.VISIBLE);
                imageView_home02.setVisibility(View.INVISIBLE);
                imageView_home01.setVisibility(View.VISIBLE);
                choiceFragment(2);
            }});
        relativeLayout_live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_live.setTextColor(0xfffa7500);
                textView_person.setTextColor(0xff000000);
                textView_hot.setTextColor(0xff000000);
                textView_vip.setTextColor(0xff000000);
                textView_home.setTextColor(0xff000000);
                imageView_live01.setVisibility(View.INVISIBLE);
                imageView_live02.setVisibility(View.VISIBLE);
                imageView_hot02.setVisibility(View.INVISIBLE);
                imageView_hot01.setVisibility(View.VISIBLE);
                imageView_person02.setVisibility(View.INVISIBLE);
                imageView_person01.setVisibility(View.VISIBLE);
                imageView_home02.setVisibility(View.INVISIBLE);
                imageView_home01.setVisibility(View.VISIBLE);
                imageView_vip02.setVisibility(View.INVISIBLE);
                imageView_vip01.setVisibility(View.VISIBLE);
                choiceFragment(3);
            }});
        relativeLayout_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_person.setTextColor(0xfffa7500);
                textView_home.setTextColor(0xff000000);
                textView_hot.setTextColor(0xff000000);
                textView_vip.setTextColor(0xff000000);
                textView_live.setTextColor(0xff000000);
                imageView_person01.setVisibility(View.INVISIBLE);
                imageView_person02.setVisibility(View.VISIBLE);;
                imageView_hot02.setVisibility(View.INVISIBLE);
                imageView_hot01.setVisibility(View.VISIBLE);
                imageView_home02.setVisibility(View.INVISIBLE);
                imageView_home01.setVisibility(View.VISIBLE);
                imageView_vip02.setVisibility(View.INVISIBLE);
                imageView_vip01.setVisibility(View.VISIBLE);
                imageView_live02.setVisibility(View.INVISIBLE);
                imageView_live01.setVisibility(View.VISIBLE);
                choiceFragment(4);
//                Fragment fragment=new Fragment5();
//                Intent intent=getIntent();
//                int image=intent.getIntExtra("image",0);
//                String name=intent.getStringExtra("name");
//                Bundle bundle=new Bundle();
//                bundle.putString("name",name);
//                bundle.putInt("image",image);
//                fragment.setArguments(bundle);
            }});
    }
    public void choiceFragment(int button_index){
    if (count!=button_index){
        ft=fm.beginTransaction();
    if (fragments[button_index]==null){
        fragments[button_index]=newfragment(button_index);
        ft.add(R.id.main_layout,fragments[button_index]);
    }else {
        ft.show(fragments[button_index]);
    }
        ft.hide(fragments[count]);
        if(button_index==4){
            Intent intent=getIntent();
            int image=intent.getIntExtra("image",0);
            if (image==0){
                image=R.drawable.btn_menu_user_center_icon_press;

            }
            String name=intent.getStringExtra("name");
            if(name==null){
                name="点击登录";
            }
            if(p==0&&button_index==4){
                Bundle bundle=new Bundle();
                bundle.putString("name",name);
                bundle.putInt("image",image);
                fragments[button_index].setArguments(bundle);
               // p=1;
            }


        }
        ft.commit();

        count=button_index;
}
    }
    public Fragment newfragment(int button_index){
       switch (button_index){
       case 0:
           return new Fragment1();
       case 1:
           return new Fragment2();
       case 2:
           return new Fragment3();
       case 3:
           return new Fragment4();
       case 4:
           return new Fragment5()
                   ;
   }
        return null;
    }
}

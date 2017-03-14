package com.example.lenovo.numbertwoapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.numbertwoapp.activity.DL_Activity;
import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.activity.SCActivity;
import com.example.lenovo.numbertwoapp.activity.WebActivity;

/**
 * Created by lenovo on 2017/2/27.
 */

public class Fragment5 extends Fragment{
    private RelativeLayout relativeLayout_sc;
    private LinearLayout linearLayout_denlu;
    private TextView textView_name;
    private ImageView imageView_touxiang;
    private  String name,newname;

    private  int image,newimage;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment5,null);
        relativeLayout_sc= (RelativeLayout) view.findViewById(R.id.sc_rl);
        linearLayout_denlu= (LinearLayout) view.findViewById(R.id.dl_ll);
        textView_name= (TextView) view.findViewById(R.id.tv_name);
        imageView_touxiang= (ImageView) view.findViewById(R.id.image_touxiang);
        Bundle bundle=getArguments();
        name=bundle.getString("name");
        image =bundle.getInt("image");
        textView_name.setText(name);
        imageView_touxiang.setBackgroundResource(image);

        relativeLayout_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),SCActivity.class);
                startActivity(i);

            }
        });
linearLayout_denlu.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(getActivity(),DL_Activity.class);
        startActivity(i);

    }
});

        return view;

    }


    @Override
    public void onResume() {
        super.onResume();
        textView_name.setText(name);
        imageView_touxiang.setBackgroundResource(image);
    }
}

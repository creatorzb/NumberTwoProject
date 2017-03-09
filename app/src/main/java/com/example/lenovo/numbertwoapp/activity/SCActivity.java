package com.example.lenovo.numbertwoapp.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.adpter.LV_Adapter;
import com.example.lenovo.numbertwoapp.mc.LoLView_C;

/**
 * Created by lenovo on 2017/3/5.
 */

public class SCActivity extends BaseActivity {
    private LoLView_C lView_c;
    private LV_Adapter lv_adapter;
    private ListView listView;
    private ImageView imageView_back;
       @Override
    public void addLayout() {
        setContentView(R.layout.sc_layout);
    }

    @Override
    public void initView() {
       listView= (ListView) findViewById(R.id.lv_sc);
        imageView_back= (ImageView) findViewById(R.id.image_scback);
        lView_c=new LoLView_C(this);
        lv_adapter=new LV_Adapter(this,lView_c.showAll());
        listView.setAdapter(lv_adapter);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SCActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(SCActivity.this,WebActivity.class);
                String url=lView_c.showAll().get(position).getUrl();
                intent.putExtra("url",url);
                startActivity(intent);
                finish();
            }
        });
    }
}

package com.example.lenovo.numbertwoapp.activity;
import android.content.Intent;

import com.example.lenovo.numbertwoapp.R;
/**
 * Created by lenovo on 2017/3/14.
 */

public class Log_Activity extends BaseActivity{
    @Override
    public void addLayout() {
        setContentView(R.layout.lead_layout);
    }

    @Override
    public void initView() {
        try {
            Thread.sleep(3000);

            Intent intent=new Intent(Log_Activity.this,MainActivity.class);
            startActivity(intent);
            finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.example.lenovo.numbertwoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.lenovo.numbertwoapp.mc.DB_C;
import com.example.lenovo.numbertwoapp.adpter.MyAdapter;
import com.example.lenovo.numbertwoapp.adpter.Image_Adapter;
import java.util.ArrayList;
import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.activity.DL_Activity;

/**
 * Created by lenovo on 2017/1/17.
 */

public class Add_activity extends AppCompatActivity {
    EditText editText_name,editText_number;
    Button button_add,button_addmage;
    ImageView button_back;
    private DB_C db_c;
    private MyAdapter adapter;
    private Image_Adapter image_adapter;
    private ArrayList<Integer>list_image;
    private GridView gridView;
    private LinearLayout layout;
    private int image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        editText_name=(EditText) findViewById(R.id.editText_name);
        editText_number=(EditText) findViewById(R.id.editText_number);
           button_add=(Button)findViewById(R.id.button_ADD);
            button_back=(ImageView) findViewById(R.id.btn_fanhui);
        gridView=(GridView) findViewById(R.id.grid_view);
        layout=(LinearLayout) findViewById(R.id.LL_bj);
          db_c=new DB_C(this);
       // adapter=new MyAdapter(this,db_c.showAll());
        add_Image();
        image_adapter=new Image_Adapter(this,list_image);
        button_addmage=(Button) findViewById(R.id.button_addimage);
        gridView.setAdapter(image_adapter);
        button_addmage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridView.setVisibility(View.VISIBLE);
                layout.setVisibility(View.INVISIBLE);

                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        image=list_image.get(position);
                        gridView.setVisibility(View.INVISIBLE);
                        layout.setVisibility(View.VISIBLE);
                        Toast.makeText(Add_activity.this,"设置成功！",Toast.LENGTH_SHORT)
                                .show();
                    }
                });
            }
        });

button_back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //跳转到登陆界面
        Intent intent=new Intent(Add_activity.this,DL_Activity.class);
        startActivity(intent);
        finish();
    }
});
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText_name.getText().toString();
                String number=editText_number.getText().toString();

                if(name!=null&&!name.equals("")&&number!=null&&!number.equals("")
                       ){
                    db_c.add(name,number,image,0);

//                    adapter.updateAdapter(db_c.showAll());
                    Toast.makeText(Add_activity.this,"添加成功！",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Add_activity.this,"输入栏不能为空！！！",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void add_Image(){
        list_image=new ArrayList<>();
        list_image.add(R.drawable.xuejie);
        list_image.add(R.drawable.lanjie);
        list_image.add(R.drawable.zb);
        list_image.add(R.drawable.ssf);
        list_image.add(R.drawable.yy);
        list_image.add(R.drawable.phy);

        list_image.add(R.drawable.xx);
        list_image.add(R.drawable.wx);
        list_image.add(R.drawable.ljx);
        list_image.add(R.drawable.xl);
        list_image.add(R.drawable.gaz);

        list_image.add(R.drawable.hjj);
        list_image.add(R.drawable.ww);
        list_image.add(R.drawable.wq);
        list_image.add(R.drawable.wys);
        list_image.add(R.drawable.lmd);

        list_image.add(R.drawable.zw);
        list_image.add(R.drawable.zl);
        list_image.add(R.drawable.ljw);
        list_image.add(R.drawable.zh);
        list_image.add(R.drawable.ysp);



    }
}

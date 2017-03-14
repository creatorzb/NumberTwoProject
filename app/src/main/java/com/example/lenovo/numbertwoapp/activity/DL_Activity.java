package com.example.lenovo.numbertwoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable.Creator;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.mc.DB_C;
import com.example.lenovo.numbertwoapp.model.User;
import java.util.ArrayList;

public class DL_Activity extends BaseActivity {
	private EditText text;
	private EditText text1;
	private TextView tv_zhuce;
	private Button btn;
	private DB_C db_c;


	@Override
	public void addLayout() {
		setContentView(R.layout.denglu);
		text1 = (EditText) findViewById(R.id.editText2);
		text = (EditText) findViewById(R.id.editText1);
		tv_zhuce = (TextView) findViewById(R.id.textView_zhuce);
		btn = (Button) findViewById(R.id.button1);
		db_c=new DB_C(this);


	}

	@Override
	public void initView() {
         btn.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View v) {
		//int i=puanDuan(text1.getText().toString(),text.getText().toString(),db_c.showAll());
if(puanDuanpassword(text1.getText().toString(),text.getText().toString(),
		puanDuan(text1.getText().toString(),text.getText().toString(),db_c.showAll()))){

	Toast.makeText(DL_Activity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
//
			Intent intent=new Intent(DL_Activity.this,MainActivity.class);
			intent.putExtra("name",text.getText().toString());
			intent.putExtra("image",db_c.selectimage(text.getText().toString()));
			startActivity(intent);
			finish();

}else if (!puanDuanpassword(text1.getText().toString(),text.getText().toString(),
		puanDuan(text1.getText().toString(),text.getText().toString(),db_c.showAll()))){
	Toast.makeText(DL_Activity.this,"账户不存在！",Toast.LENGTH_SHORT).show();
			Intent intent1=new Intent(DL_Activity.this,Add_activity.class);
			startActivity(intent1);
			finish();

}
//		if(i==0){
//			Toast.makeText(DL_Activity.this,"账户不存在！",Toast.LENGTH_SHORT).show();
//			Intent intent1=new Intent(DL_Activity.this,Add_activity.class);
//			startActivity(intent1);
//			finish();
//
//		} else if(i==1){
//			Toast.makeText(DL_Activity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
//
//			Intent intent=new Intent(DL_Activity.this,MainActivity.class);
//			intent.putExtra("name",text.getText().toString());
//			intent.putExtra("image",db_c.selectimage(text.getText().toString()));
//			startActivity(intent);
//			finish();
//		}else if(i==2){
//			Toast.makeText(DL_Activity.this,"密码错误！",Toast.LENGTH_SHORT).show();
//		}


	}});
		tv_zhuce.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent1=new Intent(DL_Activity.this,Add_activity.class);
				startActivity(intent1);
				finish();
			}
		});
	}


	private ArrayList<String> puanDuan(String name,String password,ArrayList<User>list){

		ArrayList<String> namelist =new ArrayList<>();
		for (int i=0;i<list.size();i++) {
			namelist.add(list.get(i).getName());
		}

		Log.e("名字",namelist.toString());

		return namelist;
	}
	private boolean puanDuanpassword(String name,String password,ArrayList<String>namelist){



		Log.e("名字2",namelist.toString());
		if(namelist.contains(name)){
			Log.e("密码",db_c.selectpassword(db_c.showAll(),name));
			if(db_c.selectpassword(db_c.showAll(),name).equals(password)){
				Log.e("名字2",namelist.toString());
				return true;
			}
		}
		return false;
	}



}

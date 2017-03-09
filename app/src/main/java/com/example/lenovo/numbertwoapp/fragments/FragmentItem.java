package com.example.lenovo.numbertwoapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.activity.MainActivity;
import com.example.lenovo.numbertwoapp.activity.WebActivity;
import com.example.lenovo.numbertwoapp.adpter.RecycleViewAdapter;
import com.example.lenovo.numbertwoapp.mc.LoLView_C;
import com.example.lenovo.numbertwoapp.model.User;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import android.support.v7.widget.LinearLayoutManager;


import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lenovo on 2017/2/28.
 */

public class FragmentItem extends Fragment {
    private String path;
    private TextView textView;
    private LoLView_C c;
   // private android.support.v7.widget.RecyclerView recyclerView;
    private RecyclerView recyclerView;
    private RecycleViewAdapter recycleViewAdapter;
    List<User.ResultBean.DataBean>list1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_item,null);
      //  webView= (WebView) view.findViewById(R.id.item_web);
        //textView= (TextView) view.findViewById(R.id.item_tv);
        path=getArguments().getString("path");
        recyclerView= (RecyclerView) view.findViewById(R.id.rlv);
        Log.e("qqq",path);
        getHttp(path);

        return view;}
    public void getHttp(String path){
     //  List<User.ResultBean.DataBean>list2;
// Retorfit框架获取网络数据
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/toutiao/")
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .build();
        RequestServes  requestSerives = (RequestServes) retrofit.create(RequestServes.class);//这里采用的是Java的动态代理模式
        Call<User> call = requestSerives.getWether(path,"8b41621da64fb5a7db660117a62cfa36");

        call.enqueue(new retrofit2.Callback<User>() {
                         @Override
                         public void onResponse(Call<User> call, final Response<User> response) {
                             // textView.setText(response.body().toString());
                        //response.body().getResult().getData();

                             //list1=response.body().getResult().getData();
                             getList(response.body().getResult().getData());
                             Log.e("aaaa",response.body().getResult().getData().toString());
                             //webView.loadUrl();
                         }
                         @Override
                         public void onFailure(Call<User> call, Throwable t) {
                             Log.e("dddd",t.toString());
                         }});}

    public void getList(List<User.ResultBean.DataBean> list){
        c=new LoLView_C(getContext());
        list1=list;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleViewAdapter=new RecycleViewAdapter(getContext());
        recycleViewAdapter.updateList( list1);
        recyclerView.setAdapter(recycleViewAdapter);
        recycleViewAdapter.setOclicklinstener(new RecycleViewAdapter.OnItemclicklistener() {
            @Override
            public void OnItemClickListener(View view, int position) {


                Intent intent=new Intent(getActivity(), WebActivity.class);
                intent.putExtra("url",list1.get(position).getUrl());
                intent.putExtra("name",list1.get(position).getTitle());
                intent.putExtra("image",list1.get(position).getThumbnail_pic_s());
                startActivity(intent);
                getActivity().finish();
            }
        });
    }
    public interface RequestServes {
        @GET("index")
        Call<User> getWether(@Query("type")String type,@Query("key")String key);}
}

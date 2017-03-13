package com.example.lenovo.numbertwoapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.activity.WebActivity;
import com.example.lenovo.numbertwoapp.adpter.RecycleViewAdapter;
import com.example.lenovo.numbertwoapp.mc.LoLView_C;
import com.example.lenovo.numbertwoapp.model.MyPtrHandler;
import com.example.lenovo.numbertwoapp.model.Userss;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import android.support.v7.widget.LinearLayoutManager;
import com.example.lenovo.numbertwoapp.model.MyPtrRefresher;

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

    private PtrClassicFrameLayout ptrLayout;

    private ArrayAdapter<String> adapter;
    private List<String> dataSource;
   // private android.support.v7.widget.RecyclerView recyclerView;
    private RecyclerView recyclerView;
    private RecycleViewAdapter recycleViewAdapter;
    List<Userss.ResultBean.DataBean>list1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_item,null);
      //  webView= (WebView) view.findViewById(R.id.item_web);
        //textView= (TextView) view.findViewById(R.id.item_tv);
        path=getArguments().getString("path");
        ptrLayout= (PtrClassicFrameLayout) view.findViewById(R.id.ptr_layout);
        recyclerView= (RecyclerView) view.findViewById(R.id.rlv);
        Log.e("qqq",path);
        getHttp(path);

        return view;}

    @Override
    public void onResume() {
        super.onResume();
        initData();
        initView();
        initEvent();
    }
    public void getHttp(String path){
     //  List<Userss.ResultBean.DataBean>list2;
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
        Call<Userss> call = requestSerives.getWether(path,"8b41621da64fb5a7db660117a62cfa36");

        call.enqueue(new retrofit2.Callback<Userss>() {
                         @Override
                         public void onResponse(Call<Userss> call, final Response<Userss> response) {
                             // textView.setText(response.body().toString());
                        //response.body().getResult().getData();
                             Log.e("aaaa",response.body().getResult().getData().toString());
                             //list1=response.body().getResult().getData();
                             getList(response.body().getResult().getData());

                             //webView.loadUrl();
                         }
                         @Override
                         public void onFailure(Call<Userss> call, Throwable t) {
                             Log.e("dddd",t.toString());
                         }});}

    public void getList(List<Userss.ResultBean.DataBean> list){
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
        Call<Userss> getWether(@Query("type")String type, @Query("key")String key);}

    /**
     * 初始化数据
     */
    private void initData() {
        // 初始化ListView中展示的数据
        dataSource = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            dataSource.add("Existed Old List Item " + i);
        }
    }

    /**
     * 初始化布局控件
     */
    private void initView() {
        // 初始化ListView中的数据
        //adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, dataSource);
       // recyclerView.setAdapter(adapter);
        // 为布局设置头部和底部布局
        ptrLayout.setHeaderView(new MyPtrRefresher(getActivity()));
        // ptrLayout.setFooterView(new MyPtrRefresher(MainActivity.this));
        ptrLayout.addPtrUIHandler(new MyPtrHandler(getActivity(), ptrLayout));
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        // 为布局设置下拉刷新和上拉加载的回调事件
        ptrLayout.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) { // 上拉加载的回调方法
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dataSource.add("New Bottom List Item");
                       // adapter.notifyDataSetChanged();
                        ptrLayout.refreshComplete();
                        //lv.smoothScrollToPosition(dataSource.size() - 1);
                    }
                }, 1000);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) { // 下拉刷新的回调方法
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dataSource.add(0, "New Top List Item");
                       // adapter.notifyDataSetChanged();
                        ptrLayout.refreshComplete();
                      //  lv.smoothScrollToPosition(0);
                    }
                }, 1000);
            }
        });
    }



}

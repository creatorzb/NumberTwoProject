package com.example.lenovo.numbertwoapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.lenovo.numbertwoapp.adpter.XH_Adapter;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import com.example.lenovo.numbertwoapp.activity.WebActivity;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import in.srain.cube.views.ptr.PtrFrameLayout;
import com.example.lenovo.numbertwoapp.model.MyPtrHandler;
import com.example.lenovo.numbertwoapp.model.MyPtrRefresher;
import com.example.lenovo.numbertwoapp.model.XiaoHua;
import com.example.lenovo.numbertwoapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by lenovo on 2017/2/27.
 */

public class Fragment4 extends Fragment{
    private PtrClassicFrameLayout ptrLayout;
    private List<String> dataSource;
    private int i=1;
    private ListView listView;
    private XH_Adapter xh_adapter;
    private ArrayList<XiaoHua.ResultBean.DataBean>list=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment4,null);
        listView= (ListView) view.findViewById(R.id.xiaohua_lv);
        ptrLayout= (PtrClassicFrameLayout) view.findViewById(R.id.ptr_layout);
        ruquestOne();
        return view;

    }
    @Override
    public void onResume() {
        super.onResume();
        initData();
        initView();
        initEvent();
    }
    public void ruquestOne(){

        // Retorfit框架获取网络数据
        Retrofit retrofit = new Retrofit.Builder()
       // http://japi.juhe.cn/joke/content/
                .baseUrl("http://japi.juhe.cn/joke/img/")
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .build();
        Fragment4.RequestServes  requestSerives = (Fragment4.RequestServes) retrofit.create(Fragment4.RequestServes.class);//这里采用的是Java的动态代理模式
        //                                     page=&pagesize=&key=23c40b90b893ab860e6e899b67803fdf
        Call<XiaoHua> call = requestSerives.getWether(i,30,"23c40b90b893ab860e6e899b67803fdf");
        call.enqueue(new retrofit2.Callback<XiaoHua>() {
                         @Override
                         public void onResponse(Call<XiaoHua>call, final Response<XiaoHua> response) {

                              list= (ArrayList<XiaoHua.ResultBean.DataBean>) response.body().getResult().getData();
                             Log.e("66666666666",list.toString());
                             getlist(list);
                         }

                         @Override
                         public void onFailure(Call<XiaoHua> call, Throwable t) {
                             Log.e("dddd",t.toString());
                         }
                     }


        );



                }
          public interface RequestServes {
              @GET("text.from")
              Call<XiaoHua> getWether(@Query("page")int page,@Query("pagesize")int pagesize,@Query("key")String key);

}


    private void getlist(final ArrayList<XiaoHua.ResultBean.DataBean> list){

        xh_adapter=new XH_Adapter(getContext(),list);
        listView.setAdapter(xh_adapter);
        // Log.e("aaaa",response.body().toString());
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getActivity(),WebActivity.class);
        intent.putExtra("url",list.get(position).getUrl());
        intent.putExtra("name",list.get(position).getContent());
        intent.putExtra("image",list.get(position).getUrl());
        startActivity(intent);
    }
});
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                      Log.e("滑动状态",scrollState+"");
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                if(visibleItemCount==totalItemCount){
//                      i++;
//                    ruquestOne();;
//                    xh_adapter.add(list);
//
//
//                }



            }
        });


    }
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
        ptrLayout.setFooterView(new MyPtrRefresher(getActivity()));
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
                        i++;
                   ruquestOne();;
                   xh_adapter.add(list);
                        ptrLayout.refreshComplete();
                        listView.smoothScrollToPosition(dataSource.size() - 1);
                    }
                }, 3000);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) { // 下拉刷新的回调方法
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dataSource.add(0, "New Top List Item");
                        ruquestOne();;
                        xh_adapter.update(list);;
                        // adapter.notifyDataSetChanged();
                        ptrLayout.refreshComplete();

                         listView.smoothScrollToPosition(0);
                    }
                }, 3000);
            }
        });
    }
}

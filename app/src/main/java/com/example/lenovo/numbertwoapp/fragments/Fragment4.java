package com.example.lenovo.numbertwoapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import com.example.lenovo.numbertwoapp.adpter.XH_Adapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.example.lenovo.numbertwoapp.model.XiaoHua;
import com.example.lenovo.numbertwoapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by lenovo on 2017/2/27.
 */

public class Fragment4 extends Fragment{
    private int i=1;
    private ListView listView;
    private XH_Adapter xh_adapter;
    private ArrayList<XiaoHua.ResultBean.DataBean>list=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment4,null);
        listView= (ListView) view.findViewById(R.id.xiaohua_lv);
        xh_adapter=new XH_Adapter(getContext(),ruquestOne());
        // Log.e("aaaa",response.body().toString());

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
 if(visibleItemCount==totalItemCount){
          xh_adapter.update(ruquestOne());
 }else if (firstVisibleItem+visibleItemCount==totalItemCount){
          xh_adapter.add(ruquestOne());
 }



            }
        });
        listView.setAdapter(xh_adapter);
        return view;

    }
    public ArrayList<XiaoHua.ResultBean.DataBean> ruquestOne(){

        // Retorfit框架获取网络数据
        Retrofit retrofit = new Retrofit.Builder()
       // http://japi.juhe.cn/joke/content/
                .baseUrl("http://japi.juhe.cn/joke/content/")
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .build();
        Fragment4.RequestServes  requestSerives = (Fragment4.RequestServes) retrofit.create(Fragment4.RequestServes.class);//这里采用的是Java的动态代理模式
        //                                     page=&pagesize=&key=23c40b90b893ab860e6e899b67803fdf
        Call<XiaoHua.ResultBean> call = requestSerives.getWether(1,20,"23c40b90b893ab860e6e899b67803fdf");
        call.enqueue(new retrofit2.Callback<XiaoHua.ResultBean>() {
                         @Override
                         public void onResponse(Call<XiaoHua.ResultBean>call, final Response<XiaoHua.ResultBean> response) {
                            Log.e("66666666666",response.body().toString());
                              list= (ArrayList<XiaoHua.ResultBean.DataBean>) response.body().getData();

                         }

                         @Override
                         public void onFailure(Call<XiaoHua.ResultBean> call, Throwable t) {
                             Log.e("dddd",t.toString());
                         }
                     }


        ); return list;
                }
          public interface RequestServes {
              @GET("text.from")
              Call<XiaoHua.ResultBean> getWether(@Query("page")int page,@Query("pagesize")int pagesize,@Query("key")String key);

}
}

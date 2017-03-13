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
        ruquestOne();
        return view;

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

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(visibleItemCount==totalItemCount){

                    ruquestOne();;
                    xh_adapter.update(list);


                }else if (firstVisibleItem+visibleItemCount==totalItemCount){
                   i++;
                    ruquestOne();;
                    xh_adapter.add(list);

                }



            }
        });


    }
}

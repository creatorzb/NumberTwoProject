package com.example.lenovo.numbertwoapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.adpter.RecycleViewVideoAdapter;
import com.example.lenovo.numbertwoapp.model.FootBall;
import com.example.lenovo.numbertwoapp.model.User;

import java.util.ArrayList;
import java.util.List;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static android.R.attr.path;

/**
 * Created by lenovo on 2017/2/27.
 */

public class Fragment3 extends Fragment {
    private RecycleViewVideoAdapter recycleViewVideoAdapter;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment3,null);
        recyclerView= (RecyclerView) view.findViewById(R.id.video_rlv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        getHttp(teams(getTeam()));
        return view;

    }
    public void getHttp(String team){
        //  List<User.ResultBean.DataBean>list2;
       // Retorfit框架获取网络数据
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://op.juhe.cn/onebox/basketball/")
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .build();
        Fragment3.RequestServes requestSerives = (Fragment3.RequestServes) retrofit.create(Fragment3.RequestServes.class);//这里采用的是Java的动态代理模式
        Call<FootBall> call = requestSerives.getWether(team,"c3630b78e75fc7f2dd4c8481b092f6e2");

        call.enqueue(new retrofit2.Callback<FootBall>() {
            @Override
    public void onResponse(Call<FootBall> call, final Response<FootBall> response) {
                // textView.setText(response.body().toString());
                //response.body().getResult().getData();
                Log.e("ffff",response.body().getResult().getList().toString());
                recycleViewVideoAdapter=new RecycleViewVideoAdapter(getContext());
                recycleViewVideoAdapter.updateList(response.body().getResult().getList());
                recyclerView.setAdapter(recycleViewVideoAdapter);


                //list1=response.body().getResult().getData();
               //  getList(response.body().getResult().getData());

                //Log.e("aaaa",response.body().getResult().getData().toString());
                //webView.loadUrl();
            }
            @Override
    public void onFailure(Call<FootBall> call, Throwable t) {
                Log.e("dddd",t.toString());
            }});}
    public interface RequestServes {
              @GET("team")
               Call<FootBall> getWether(@Query("team")String type,@Query("key")String key);}
//
//    private void playfunction(String path){
//        if (path==""){
//            // Tell the user to provide a media file URL/path. 
//            Toast.makeText(getContext(),"请设置视频的URI地址", Toast.LENGTH_LONG).show();
//            return;}else{/*     * Alternatively,for streaming media you can use     * mVideoView.setVideoURI(Uri.parse(URLstring));     */
//            videoView.setVideoPath(path);
//            videoView.setMediaController(new MediaController(getContext()));
//            videoView.requestFocus();
//            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
//                @Override
//    public void onPrepared(MediaPlayer mp) {
//
//
//                }});}}

    public ArrayList<String> getTeam(){
         ArrayList<String>list=new ArrayList<>();
          list.add("老鹰");
          list.add("凯尔特人");
          list.add("山猫");
          list.add("公牛");
          list.add("骑士");

          list.add("小牛");
          list.add("掘金");
          list.add("活塞");
          list.add("勇士");
          list.add("火箭");

          list.add("步行者");
          list.add("快船");
          list.add("湖人");
          list.add("灰熊");
          list.add("热火");

          list.add("雄鹿");
          list.add("森林狼");
          list.add("篮网");
          list.add("鹈鹕");
          list.add("尼克斯");

          list.add("魔术");
          list.add("76人");
          list.add("太阳");
          list.add("开拓者");
          list.add("国王");

         list.add("马刺");
         list.add("雷霆");
         list.add("猛龙");
         list.add("爵士");
         list.add("奇才");
         return list;}


    public String teams(ArrayList<String>list){
        String team=null;
        for (int i=0;i<list.size();i++){

            team= list.get(i);
        }
        return team;

    }
}




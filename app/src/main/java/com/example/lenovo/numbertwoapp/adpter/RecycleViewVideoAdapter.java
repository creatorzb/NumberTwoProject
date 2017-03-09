package com.example.lenovo.numbertwoapp.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.model.FootBall;
import com.example.lenovo.numbertwoapp.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by Zhang on 2017/3/1.
 */
public class RecycleViewVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<FootBall.ResultBean.ListBean> list;
    private Context context;
    public RecycleViewVideoAdapter(Context context){
     this.context=context;

            }
    //添加数据
    public void addList( List<FootBall.ResultBean.ListBean> list){
//        if(this.list.containsAll(list)){
//            return;
//        }
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    //更新数据
    public void updateList( List<FootBall.ResultBean.ListBean> list){
        this.list=list;
        notifyDataSetChanged();
        Log.e("wwww",list.toString());
    }


    @Override
    public  RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            RecyclerView.ViewHolder holder=null;
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_video, parent,false);
            holder=new MyViewHolder1(view);

        return holder;
    }

     //复写类型设置方法


    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
            MyViewHolder1 holder1= (MyViewHolder1) holder;
          playfunction(holder1,list.get(position).getLink1url());
      //  holder1.videoView.setVideoPath(list.get(position).getM_link1url());

//            holder1.tv_title.setText(list.get(position).getTitle());
//            holder1.tv_date.setText(list.get(position).getDate());
//            holder1.textView_auther.setText(list.get(position).getAuthor_name());
//            Picasso.with(context).load(list.get(position).getThumbnail_pic_s()).resize(200,200).into(holder1.imageView_01);

    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getLink1url()!=null){
            return 1;
        }




        return 2;




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder{
     TextView tv_title,tv_date,textView_auther;
        ImageView imageView_01;
        private VideoView videoView;
        public MyViewHolder1(View itemView) {
            super(itemView);
            videoView= (VideoView) itemView.findViewById(R.id.videos);

//            tv_title= (TextView) itemView.findViewById(R.id.title_i1);
//            tv_date= (TextView) itemView.findViewById(R.id.date_i1);
//            textView_auther= (TextView) itemView.findViewById(R.id.author_i1);
//            imageView_01= (ImageView) itemView.findViewById(R.id.image_i1);

        }
    }
    private void playfunction(MyViewHolder1 holder,String path){
        if (path==""){
            // Tell the user to provide a media file URL/path. 
            Toast.makeText(context,"请设置视频的URI地址", Toast.LENGTH_LONG).show();
            return;}else{/*     * Alternatively,for streaming media you can use     * mVideoView.setVideoURI(Uri.parse(URLstring));     */
           holder.videoView.setVideoPath(path);
            holder.videoView.setMediaController(new MediaController(context));
            holder.videoView.requestFocus();
            holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
                @Override
    public void onPrepared(MediaPlayer mp) {
                      mp.start();

                }});}}
//    class MyViewHolder2 extends RecyclerView.ViewHolder{
//        TextView tv_title,tv_date,textView_auther;
//        ImageView imageView_01,imageView_02;
//        public MyViewHolder2(View itemView) {
//            super(itemView);
//            tv_title= (TextView) itemView.findViewById(R.id.title_ii1);
//            tv_date= (TextView) itemView.findViewById(R.id.date_ii1);
//            textView_auther= (TextView) itemView.findViewById(R.id.author_ii1);
//            imageView_01= (ImageView) itemView.findViewById(R.id.image_ii1);
//            imageView_02= (ImageView) itemView.findViewById(R.id.image_ii2);
//
//        }
//    }
//    class MyViewHolder3 extends RecyclerView.ViewHolder{
//        TextView tv_title,tv_date,textView_auther;
//        ImageView imageView_01,imageView_02,imageView_03;
//        public MyViewHolder3(View itemView) {
//            super(itemView);
//            tv_title= (TextView) itemView.findViewById(R.id.title_iii1);
//            tv_date= (TextView) itemView.findViewById(R.id.date_iii1);
//            textView_auther= (TextView) itemView.findViewById(R.id.author_iii1);
//            imageView_01= (ImageView) itemView.findViewById(R.id.image_iii1);
//            imageView_02= (ImageView) itemView.findViewById(R.id.image_iii2);
//            imageView_03= (ImageView) itemView.findViewById(R.id.image_iii3);
//        }
//    }
}

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

        if(this.list==null){
            this.list=list;
            notifyDataSetChanged();
            return;
        }else {
            this.list.addAll(list);
            notifyDataSetChanged();
        }

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
        holder1.tv_team01.setText(list.get(position).getPlayer1());
        holder1.textView_team02.setText(list.get(position).getPlayer2());
        holder1.tv_vs.setText("VS");
        holder1.textView_date.setText(list.get(position).getM_time());
        Picasso.with(context).load(list.get(position).getPlayer1logo()).resize(50,50).into(holder1.imageView_01);
        Picasso.with(context).load(list.get(position).getPlayer2logo()).resize(50,50).into(holder1.imageView_02);

//            holder1.tv_title.setText(list.get(position).getTitle());
//            holder1.tv_date.setText(list.get(position).getDate());
//            holder1.textView_auther.setText(list.get(position).getAuthor_name());
//

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
     TextView tv_team01,tv_vs,textView_team02,textView_date;

        ImageView imageView_01,imageView_02;
        public MyViewHolder1(View itemView) {
            super(itemView);
            tv_team01= (TextView) itemView.findViewById(R.id.team_name_01);
            tv_vs= (TextView) itemView.findViewById(R.id.tv_vs);
            textView_team02= (TextView) itemView.findViewById(R.id.team_name_02);
            textView_date= (TextView) itemView.findViewById(R.id.tv_date);
            imageView_01= (ImageView) itemView.findViewById(R.id.image_team_01);
            imageView_02= (ImageView) itemView.findViewById(R.id.image_team_02);


        }
    }

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

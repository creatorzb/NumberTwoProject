package com.example.lenovo.numbertwoapp.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.numbertwoapp.R;

import java.util.ArrayList;
import java.util.List;
import  com.example.lenovo.numbertwoapp.model.User;
import com.squareup.picasso.Picasso;

/**
 * Created by Zhang on 2017/3/1.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<User.ResultBean.DataBean> list;
    private Context context;
    public RecycleViewAdapter(Context context){
     this.context=context;

            }
    //添加数据
    public void addList( List<User.ResultBean.DataBean> list){
//        if(this.list.containsAll(list)){
//            return;
//        }
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    //更新数据
    public void updateList( List<User.ResultBean.DataBean> list){
        this.list=list;
        notifyDataSetChanged();
        Log.e("wwww",list.toString());
    }


    @Override
    public  RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder=null;
        if(viewType==1){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item1, parent,false);
            holder=new MyViewHolder1(view);
        }else if(viewType==2){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item2,parent,false);
            holder=new MyViewHolder2(view);
        }else{
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item3,parent,false);
            holder=new MyViewHolder3(view);
        }

        return holder;
    }

     //复写类型设置方法
    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getThumbnail_pic_s()!=null&&list.get(position).getThumbnail_pic_s02()==null&&
                list.get(position).getThumbnail_pic_s03()==null){
            return 1;
        }else if(list.get(position).getThumbnail_pic_s()!=null&&list.get(position).getThumbnail_pic_s02()!=null&&
                list.get(position).getThumbnail_pic_s03()==null){
            return 2;
        }else{
            return 3;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof MyViewHolder1 ) {
            MyViewHolder1 holder1= (MyViewHolder1) holder;
            holder1.tv_title.setText(list.get(position).getTitle());
            holder1.tv_date.setText(list.get(position).getDate());
            holder1.textView_auther.setText(list.get(position).getAuthor_name());
            Picasso.with(context).load(list.get(position).getThumbnail_pic_s()).resize(200,200).into(holder1.imageView_01);

        }else if (holder instanceof MyViewHolder2){
            MyViewHolder2 holder2= (MyViewHolder2) holder;
            holder2.tv_title.setText(list.get(position).getTitle());
            holder2.tv_date.setText(list.get(position).getDate());
            holder2.textView_auther.setText(list.get(position).getAuthor_name());
            Picasso.with(context).load(list.get(position).getThumbnail_pic_s()).resize(200,200).into(holder2.imageView_01);
            Picasso.with(context).load(list.get(position).getThumbnail_pic_s02()).resize(200,200).into(holder2.imageView_02);
        }else {
            MyViewHolder3 holder3= (MyViewHolder3) holder;
            holder3.tv_title.setText(list.get(position).getTitle());
            holder3.tv_date.setText(list.get(position).getDate());
            holder3.textView_auther.setText(list.get(position).getAuthor_name());
            Picasso.with(context).load(list.get(position).getThumbnail_pic_s()).resize(200,200).into(holder3.imageView_01);
            Picasso.with(context).load(list.get(position).getThumbnail_pic_s02()).resize(200,200).into(holder3.imageView_02);
            Picasso.with(context).load(list.get(position).getThumbnail_pic_s03()).resize(200,200).into(holder3.imageView_03);
        }
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (onItemclicklistener!=null){
            onItemclicklistener.OnItemClickListener(v,position);
        }

    }
});
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder{
     TextView tv_title,tv_date,textView_auther;
        ImageView imageView_01;
        public MyViewHolder1(View itemView) {
            super(itemView);
            tv_title= (TextView) itemView.findViewById(R.id.title_i1);
            tv_date= (TextView) itemView.findViewById(R.id.date_i1);
            textView_auther= (TextView) itemView.findViewById(R.id.author_i1);
            imageView_01= (ImageView) itemView.findViewById(R.id.image_i1);

        }
    }
    class MyViewHolder2 extends RecyclerView.ViewHolder{
        TextView tv_title,tv_date,textView_auther;
        ImageView imageView_01,imageView_02;
        public MyViewHolder2(View itemView) {
            super(itemView);
            tv_title= (TextView) itemView.findViewById(R.id.title_ii1);
            tv_date= (TextView) itemView.findViewById(R.id.date_ii1);
            textView_auther= (TextView) itemView.findViewById(R.id.author_ii1);
            imageView_01= (ImageView) itemView.findViewById(R.id.image_ii1);
            imageView_02= (ImageView) itemView.findViewById(R.id.image_ii2);

        }
    }
    class MyViewHolder3 extends RecyclerView.ViewHolder{
        TextView tv_title,tv_date,textView_auther;
        ImageView imageView_01,imageView_02,imageView_03;
        public MyViewHolder3(View itemView) {
            super(itemView);
            tv_title= (TextView) itemView.findViewById(R.id.title_iii1);
            tv_date= (TextView) itemView.findViewById(R.id.date_iii1);
            textView_auther= (TextView) itemView.findViewById(R.id.author_iii1);
            imageView_01= (ImageView) itemView.findViewById(R.id.image_iii1);
            imageView_02= (ImageView) itemView.findViewById(R.id.image_iii2);
            imageView_03= (ImageView) itemView.findViewById(R.id.image_iii3);
        }
    }
    private OnItemclicklistener onItemclicklistener;
    public void setOclicklinstener(OnItemclicklistener onItemclicklistener){
        this.onItemclicklistener=onItemclicklistener;
    }
   public interface OnItemclicklistener{
      void OnItemClickListener(View view,int position);

    }
}

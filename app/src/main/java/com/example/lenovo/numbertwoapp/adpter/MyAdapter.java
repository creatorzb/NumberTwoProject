package com.example.lenovo.numbertwoapp.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.lenovo.numbertwoapp.model.User;
import java.util.ArrayList;
import com.example.lenovo.numbertwoapp.R;

/**
 * Created by lenovo on 2017/1/15.
 */

public class MyAdapter extends BaseAdapter {
private     ArrayList<User>list1;
private Context context1;
    public  MyAdapter(Context context,ArrayList<User>list){
        this.context1=context;
        this.list1=list;

    }

    public ArrayList<User> getList1() {
        return list1;
    }
    public void updateAdapter(ArrayList list){
        this.list1=list;
        notifyDataSetChanged();
    }

    public void setList1(ArrayList<User> list1) {
        this.list1 = list1;
    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        YouHua youHua;
        if(view==null){
            view= LayoutInflater.from(context1).inflate(R.layout.item_activity,null);
            youHua=new YouHua();
            youHua.textView_name=(TextView) view.findViewById(R.id.name);
            youHua.textView_number=(TextView) view.findViewById(R.id.bianhao);
            youHua.checkBox=(CheckBox) view.findViewById(R.id.checkBox);
            youHua.imageView=(ImageView) view.findViewById(R.id.image_view);
            view.setTag(youHua);
        }
        youHua=(YouHua) view .getTag();
        youHua.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list1.get(position).setCheckBox(!list1.get(position).isCheckBox());
            }
        });
        youHua.textView_name.setText(list1.get(position).getName());
        youHua.textView_number.setText(list1.get(position).getNumber());
        youHua.imageView.setImageResource(list1.get(position).getImage());

        youHua.checkBox.setChecked(list1.get(position).isCheckBox());



        return view;
    }
    class YouHua{
        TextView textView_name,textView_number;
        CheckBox checkBox;
        ImageView imageView;

    }
}
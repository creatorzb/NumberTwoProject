package com.example.lenovo.numbertwoapp.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.model.Person;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/2/23.
 */

public class LV_Adapter extends BaseAdapter{
    private ArrayList<Person>list;
    private Context context;
    public LV_Adapter(Context context, ArrayList<Person>list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    class ViewHoler{
        private TextView textView_name,textView_url;
        private ImageView imageView;



    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler viewHoler;
        if(convertView==null){
            viewHoler=new ViewHoler();
           convertView= LayoutInflater.from(context).inflate(R.layout.item_layout,null);
           viewHoler.textView_name= (TextView) convertView.findViewById(R.id.textView_name);
           viewHoler.textView_url= (TextView) convertView.findViewById(R.id.textView_url);
           viewHoler.imageView= (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHoler);
        }
           viewHoler= (ViewHoler) convertView.getTag();
        viewHoler.textView_name.setText((list.get(position).getUrl()));
        viewHoler.textView_url.setText(list.get(position).getName());
        Picasso.with(context).load(list.get(position).getImage()).resize(45,45).centerCrop().into(viewHoler.imageView);



        return convertView;
    }
}

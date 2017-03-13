package com.example.lenovo.numbertwoapp.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.example.lenovo.numbertwoapp.R;
import java.util.ArrayList;

/**
 * Created by lenovo on 2017/1/18.
 */

public class Image_Adapter extends BaseAdapter {
    private ArrayList<Integer>list_image;
    private Context context;
    public Image_Adapter(Context context,ArrayList<Integer>list_image){
        this.context=context;
        this.list_image=list_image;

    }
    @Override
    public int getCount() {
        return list_image.size();
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
    public View getView(int position, View view, ViewGroup parent) {
        Yh yh;
        if(view==null){
            view=LayoutInflater.from(context).inflate(R.layout.item_gridview,null);
          yh=new Yh();
            yh.imageView=(ImageView) view.findViewById(R.id.image_gridview);
            view.setTag(yh);
        }
           yh=(Yh) view.getTag();
        yh.imageView.setImageResource(list_image.get(position));


        return view;
    }
    class Yh{
        ImageView imageView;
    }
}

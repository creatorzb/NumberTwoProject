package com.example.lenovo.numbertwoapp.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.lenovo.numbertwoapp.model.XiaoHua;
import com.example.lenovo.numbertwoapp.R;
import com.example.lenovo.numbertwoapp.model.Person;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */

public class XH_Adapter extends BaseAdapter{
    private ArrayList<XiaoHua.ResultBean.DataBean>list;
    private Context context;
    public XH_Adapter(Context context, ArrayList<XiaoHua.ResultBean.DataBean> list){
        this.context=context;
        this.list=list;
    }
    public void add(ArrayList<XiaoHua.ResultBean.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    public void update(ArrayList<XiaoHua.ResultBean.DataBean> list){
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
        private TextView textView_name,textView_date;




    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler viewHoler;
        if(convertView==null){
            viewHoler=new ViewHoler();
           convertView= LayoutInflater.from(context).inflate(R.layout.item_layout,null);
           viewHoler.textView_name= (TextView) convertView.findViewById(R.id.textView_name);
           viewHoler.textView_date= (TextView) convertView.findViewById(R.id.textView_url);

            convertView.setTag(viewHoler);
        }
           viewHoler= (ViewHoler) convertView.getTag();
        viewHoler.textView_name.setText((list.get(position).getContent()));
        viewHoler.textView_date.setText(list.get(position).getUpdatetime());




        return convertView;
    }
}

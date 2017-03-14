package com.example.lenovo.numbertwoapp.mc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.lenovo.numbertwoapp.model.Person;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/1/9.
 */

public class LoLView_C {
    private SQLiteDatabase db;

    Context context;
    public LoLView_C(Context context){
        this.context=context;
        db=new ListView_M(context).getWritableDatabase();
    }


    public void  add(Person p, ArrayList<Person>list) {
        for (Person person : list) {
            if (!person.getUrl().equals(p.getUrl()) && p.getUrl() != null) {

                String sql = "insert into " + ListView_M.table_name + " values ( null ,' "+p.getUrl()+"','"+p.getName()+"','"+ p.getImage()+" ') ";
                db.execSQL(sql);
                return;
            }else if (p.getName()==null){
                Toast.makeText(context,"内容不能为空！",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context,"已经收藏！",Toast.LENGTH_SHORT).show();
            }
        }

//       if (!list.contains(p)){
//           if (p.getName()!=null){
//        }else {
//               Toast.makeText(context,"收藏不能为空！",Toast.LENGTH_SHORT).show();
//           }
//
//
//       }else {
          // Toast.makeText(context,"已经收藏！",Toast.LENGTH_SHORT).show();
           //}
    }
//    public void allChose(ArrayList<Person>list){
//        for (Person P:list) {
//            if(P.isCheckBox()){
//                P.setCheckBox(false);
//                Log.e("msg1",""+P.isCheckBox());
//            }else {
//                P.setCheckBox(true);
//                Log.e("msg2",""+P.isCheckBox());
//            }
//
//
//
//
//        }
//    }
public boolean saixuan(Person p,ArrayList<Person>list){
    Log.e("fffffff",p.getName()+" ");
    for (Person person:list) {
        if (person.getName().equals(p.getName())){
            Log.e("fffffff2222222",person.getUrl()+" ");
            return true;
        }
    }
return false;
}
    public void delete(Person person,ArrayList<Person>list){
        Log.e("fffffff",person.getName()+" ");
        for (Person p:list) {
           if (p.getName().equals(person.getName())) {
               Log.e("fffffff44444444444444",p.getName()+" ");
               String sql = "delete from " + ListView_M.table_name + " where name='"+person.getName()+" '";
               db.execSQL(sql);
                 return;

           }
        }
    }

    /**
     * 查看所有数据
     */
    public ArrayList<Person> showAll(){
        ArrayList<Person> list=new ArrayList<Person>();
        String sql="select * from " +ListView_M.table_name ;
        Cursor cursor= db.rawQuery(sql,null);
        while(cursor.moveToNext()){

//             Userss user =new Userss();
//             String name=cursor.getString(cursor.getColumnIndex("name"));
//            user.setName(name);
//            user.setName(cursor.getString(cursor.getColumnIndex("name")));
//            user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
//            Userss user =new Userss(cursor.getString(cursor.getColumnIndex("name")),
//                    cursor.getString(cursor.getColumnIndex("password")));
            list.add(new Person(cursor.getString(cursor.getColumnIndex("url")),
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("image"))));

        }
        cursor.close();
        return list;
    }

    public void update(String name,String type,String price,int id){
    String sql="UPDATE "+ListView_M.table_name +" set name ='"+name
            +"',type = '"+type
        +"',price ='"+price+" 'WHERE _id='"+id+"'";

        db.execSQL(sql);


    }
public int  id(String name){
    int id;

    String sql="select _id from" +ListView_M.table_name
            +" where name='"+name+"'";
    Cursor cursor= db.rawQuery(sql,null);
    while (cursor.moveToNext()){

        id=cursor.getInt(cursor.getColumnIndex("_id"));
        return id;
    }
            return 0;
}

}

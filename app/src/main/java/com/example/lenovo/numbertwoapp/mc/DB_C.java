package com.example.lenovo.numbertwoapp.mc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;
import com.example.lenovo.numbertwoapp.model.User;
import java.util.ArrayList;

/**
 * Created by lenovo on 2017/1/17.
 */

public class DB_C {
    private SQLiteDatabase db;
    private Context context;
    public DB_C (Context context){
        this.context=context;
        db=new DB_M(context).getWritableDatabase();
    }

    public void  add(String name,String number,int image,int cs){
        String sql="insert into "+ DB_M.table_name +" values (null,' "+name
                +" ','"+number+" ','"+image+" ','"+cs+"')";
        db.execSQL(sql);
    }
    public void delete(ArrayList<User> list){
        for (User p:list) {
            if(p.isCheckBox()){
                String sql="delete from " + DB_M.table_name + " where name='"+p.getName()+"'";
                db.execSQL(sql);
                Toast.makeText(context,"删除成功！",Toast.LENGTH_SHORT).show();

            }
        }
    }
    public void deletes(ArrayList<User> list2){
        ArrayList<User>list1=list2;
        for (int i=0;i<list1.size();i++){
            String sql="delete from " + DB_M.table_name + " where name='"+list1.get(i).getName()+"'";
            db.execSQL(sql);
            Log.e("dad",list1.get(i).getName());

        }






    }
    public ArrayList<User> showAll(){
        ArrayList<User> list=new ArrayList<User>();
        String sql="select * from " +DB_M.table_name ;
        Cursor cursor= db.rawQuery(sql,null);
        while(cursor.moveToNext()){

//             Userss user =new Userss();
//             String name=cursor.getString(cursor.getColumnIndex("name"));
//            user.setName(name);
//            user.setName(cursor.getString(cursor.getColumnIndex("name")));
//            user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
//            Userss user =new Userss(cursor.getString(cursor.getColumnIndex("name")),
//                    cursor.getString(cursor.getColumnIndex("password")));
            list.add(new User(cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("number")),
                    cursor.getInt(cursor.getColumnIndex("image")),
                    cursor.getInt(cursor.getColumnIndex("cs"))

                    ));
        }
        cursor.close();
        return list;
    }
    public String selectname (ArrayList<User> list,int id){
        ArrayList<User>listt=list;
        String sname=null;
        listt.get(id).setCs(listt.get(id).getCs()+1);
        int a=listt.get(id).getCs();
        String sq2="UPDATE "+DB_M.table_name +" set cs ='"+a
               +" 'WHERE name='"+listt.get(id).getName()+"'";

        db.execSQL(sq2);
        String sql="select name from " +DB_M.table_name +" where  name='"+listt.get(id).getName()+"'";
       Cursor cursor=db.rawQuery(sql,null);

while (cursor.moveToNext()){
            sname=cursor.getString(cursor.getColumnIndex("name"));
    return sname;
        }
return null;
    }
    public int selectimage(ArrayList<User> list,int id){
        ArrayList<User>listt1=list;
        int image=0;
        String sql="select image from " +DB_M.table_name +" where  name='"+listt1.get(id).getName()+"'";
        Cursor cursor=db.rawQuery(sql,null);

        while (cursor.moveToNext()){
            image=cursor.getInt(cursor.getColumnIndex("image"));

        }
        return image;
    }
    public ArrayList<User> paixu(ArrayList<User> list){
        ArrayList<User> list2=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).getCs()<list.get(j).getCs()){
                    String n=list.get(i).getName();
                    list.get(i).setName(list.get(j).getName());
                    list.get(j).setName(n);
                    String h=list.get(i).getNumber();
                    list.get(i).setNumber(list.get(j).getNumber());
                    list.get(j).setNumber(h);
                    int t=list.get(i).getImage();
                    list.get(i).setImage(list.get(j).getImage());
                    list.get(j).setImage(t);
                    int o=list.get(i).getCs();
                    list.get(i).setCs(list.get(j).getCs());
                    list.get(j).setCs(o);

                }
            }

        }

        for(int i=0;i<list.size();i++){
            list2.add(list.get(i));

        }
        return list2;
    }
}

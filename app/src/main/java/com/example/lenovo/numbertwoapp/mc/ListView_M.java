package com.example.lenovo.numbertwoapp.mc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenovo on 2017/1/9.
 */

public class ListView_M extends SQLiteOpenHelper{
    public static final String table_name=" user";




    public ListView_M(Context context) {
        super(context,"User", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String  table_sql="create table "+table_name+"( _id  integer primary key autoincrement," +
                " url varchar(50) not null, name varchar(50),image varchar(100) )";
        db.execSQL(table_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

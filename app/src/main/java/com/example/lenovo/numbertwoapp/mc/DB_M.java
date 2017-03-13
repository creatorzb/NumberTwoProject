package com.example.lenovo.numbertwoapp.mc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenovo on 2017/1/17.
 */

public class DB_M extends SQLiteOpenHelper {
    public static final String table_name="User01";
    public DB_M(Context context) {
        super(context, "User01",null,2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String  table_sql="create table "+table_name+"( _id  integer primary key autoincrement," +
                " name varchar(8) not null, number varchar(10),image varchar(30),cs varchar(10) )";
        db.execSQL(table_sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

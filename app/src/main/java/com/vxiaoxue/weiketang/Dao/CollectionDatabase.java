package com.vxiaoxue.weiketang.Dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 创建我的收藏数据库
 * Created by Administrator on 2015/10/16.
 */
public class CollectionDatabase extends SQLiteOpenHelper{
    private static final String name = "collection.db";//数据库的名称
    private static final int version = 1;//数据库的版本
    public CollectionDatabase(Context context) {
        super(context, name, null, version);
    }

    //数据库创建的时候去调用
    @Override
    public void onCreate(SQLiteDatabase db) {
          db.execSQL("create table collectiondata(id integer primary key autoincrement,name varchar(20),des varchar(20),time varchar(20))");
    }
    //版本更新的时候调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

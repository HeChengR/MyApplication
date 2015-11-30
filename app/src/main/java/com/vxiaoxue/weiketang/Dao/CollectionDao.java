package com.vxiaoxue.weiketang.Dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.vxiaoxue.weiketang.domain.CollectionDb;

import java.util.List;

/**
 * 数据库增删改查的接口
 * Created by Administrator on 2015/10/22.
 */
public interface CollectionDao {
    /**
     * 增加的操作
     */
    boolean insert(SQLiteDatabase db, ContentValues values);

    /**
     * 根据id删除的操作
     */
    boolean delete(SQLiteDatabase db, Integer id);

    /**
     * 根据id更改的操作
     */
    boolean update(SQLiteDatabase db, ContentValues values, Integer id);

    /**
     * 查询所有的操作
     */
    List<CollectionDb> findAll(SQLiteDatabase db);

    /**
     * 条件查询操作
     */
    List<CollectionDb> findByName(SQLiteDatabase db, String[] SelectionArgs);
}

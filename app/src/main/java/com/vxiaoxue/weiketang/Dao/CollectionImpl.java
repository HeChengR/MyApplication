package com.vxiaoxue.weiketang.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vxiaoxue.weiketang.domain.CollectionDb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/22.
 */
public class CollectionImpl implements CollectionDao {
    @Override
    public boolean insert(SQLiteDatabase db, ContentValues values) {
        boolean flag = false;
        if (db.isOpen()){
            long l = db.insert("collectiondata", null, values);
            if (l>0){
                flag = true;
            }
            db.close();
        }

        return flag;
    }

    @Override
    public boolean delete(SQLiteDatabase db, Integer id) {
        boolean flag = false;
        if (db.isOpen()){
            long l = db.delete("collectiondata","id=?",new String[]{id+""});
            if (l>0){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean update(SQLiteDatabase db, ContentValues values, Integer id) {
        boolean flag=false;
        if(db.isOpen()){
            long l=db.update("collectiondata", values, "id=?", new String[]{id+""});
            if(l>0){
                flag=true;
            }
            db.close();
        }
        return flag;
    }

    @Override
    public List<CollectionDb> findAll(SQLiteDatabase db) {
        List<CollectionDb> collection = new ArrayList<>();
        if (db.isOpen()){
          Cursor cursor =  db.query("collectiondata", new String[]{"id","name", "des", "time"}, null, null, null, null, null, null);
            while(cursor.moveToNext()){
                CollectionDb collectionDb = new CollectionDb();
                collectionDb.setId(cursor.getInt(cursor.getColumnIndex("id")));
                collectionDb.setName(cursor.getString(cursor.getColumnIndex("name")));
                collectionDb.setDes(cursor.getString(cursor.getColumnIndex("des")));
                collectionDb.setTime(cursor.getString(cursor.getColumnIndex("time")));
                collection.add(collectionDb);
            }
        }
        return collection;
    }

    @Override
    public List<CollectionDb> findByName(SQLiteDatabase db, String[] SelectionArgs) {
        ArrayList<CollectionDb> collectionList = new ArrayList<>();
        if (db.isOpen()){
            Cursor cursor = db.query("collectiondata", new String[]{"id", "name", "des", "time"}, "id=?", SelectionArgs, null, null, null, null);
            while(cursor.moveToNext()){
                CollectionDb collectionDb  = new CollectionDb();
                collectionDb.setId(cursor.getInt(cursor.getColumnIndex("id")));
                collectionDb.setName(cursor.getString(cursor.getColumnIndex("name")));
                collectionDb.setDes(cursor.getString(cursor.getColumnIndex("des")));
                collectionDb.setTime(cursor.getString(cursor.getColumnIndex("time")));
                collectionList.add(collectionDb);
            }
        }
        return collectionList;
    }
}

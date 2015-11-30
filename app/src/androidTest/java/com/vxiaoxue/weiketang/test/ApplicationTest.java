package com.vxiaoxue.weiketang.test;

import android.app.Application;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.test.ApplicationTestCase;

import com.vxiaoxue.weiketang.Dao.CollectionDao;
import com.vxiaoxue.weiketang.Dao.CollectionDatabase;
import com.vxiaoxue.weiketang.Dao.CollectionImpl;
import com.vxiaoxue.weiketang.domain.CollectionDb;

import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    CollectionDao collection = new CollectionImpl();

    public ApplicationTest() {
        super(Application.class);
    }

    public void testCreateDb() {
        CollectionDatabase collectionDatabase = new CollectionDatabase(this.getContext());
        SQLiteDatabase sqLiteDatabase = collectionDatabase.getWritableDatabase();
    }
    public void testInsert(){
        CollectionDatabase collectionDatabase = new CollectionDatabase(this.getContext());
        for (int index = 0;index < 10;index++){
            SQLiteDatabase sqLiteDatabase = collectionDatabase.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            CollectionDb collectionDb = new CollectionDb(index,"hecheng"+index,"ninhao"+index,"2015.10.22");
            contentValues.put("id",collectionDb.getId());
            contentValues.put("name",collectionDb.getName());
            contentValues.put("des",collectionDb.getDes());
            contentValues.put("time",collectionDb.getTime());
            collection.insert(sqLiteDatabase,contentValues);
        }

    }

    public void testQuery() {
        CollectionDatabase collectionDatabase = new CollectionDatabase(this.getContext());
        SQLiteDatabase sqLiteDatabase = collectionDatabase.getWritableDatabase();
        List<CollectionDb> persons = collection.findAll(sqLiteDatabase);
        for (CollectionDb p : persons) {
            System.out.println(p.toString());
        }
    }
    public void testUpdate(){
        CollectionDatabase collectionDatabase = new CollectionDatabase(this.getContext());
        SQLiteDatabase sqLiteDatabase = collectionDatabase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        CollectionDb collectionDb = new CollectionDb(5,"hecheng","ninhao","2015.10.23");
        contentValues.put("id",collectionDb.getId());
        contentValues.put("name",collectionDb.getName());
        contentValues.put("des",collectionDb.getDes());
        contentValues.put("time",collectionDb.getTime());
        collection.update(sqLiteDatabase,contentValues,5);
    }
}
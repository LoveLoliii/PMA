package com.summersama.pma.tool;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.summersama.pma.model.PmaBean;

import java.util.ArrayList;

/**
 * Created by woshi on 2016/3/28.
 */
public class DbHelper extends SQLiteOpenHelper {
    String userName = "userName";
    String password = "password";
    int pmarId;

    public DbHelper(Context context) {
        super(context, "pam.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //login or sign table
        db.execSQL("CREATE TABLE IF NOT EXISTS pmar"+
        "(pmarId integer primary key autoincrement,"+
        "userName varchar(50),"+
        "password varchar(50))");
        //pma sava main table
        db.execSQL("CREATE TABLE IF NOT EXISTS pma"+
                "(pmaId integer primary key autoincrement,"+
                "userName varchar(50),"+
                "password varchar(50),"+"other varchar(50))");
        initInsert(db);

    }

    private void initInsert(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put("pmarId",1);
        values.put(userName,"root");
        values.put(password, "123456");
        db.insert("pmar", null, values);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertRecored(PmaBean bean){
            ContentValues values = new ContentValues();
            values.put("userName",bean.getUserName());
            values.put("password",bean.getPassword());
            SQLiteDatabase db =getWritableDatabase();
        long count = db.insert("pma",null,values);
        return (int) count;
    }

    public int deleteRecord(int pmarId){
        SQLiteDatabase db = getWritableDatabase();
        int count = db.delete("pmar", pmarId + "=?", new String[]{"" + pmarId});
        return count;
    }
    public ArrayList<PmaBean> queryAll(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c =db.query("pma", null, null, null, null, null, null);
        ArrayList<PmaBean> pma = new ArrayList<PmaBean>();
        while (c.moveToNext()){
            int pmaId = c.getInt(0);
            String userName = c.getString(c.getColumnIndex("userName"));
            String password = c.getString(c.getColumnIndex("password"));
            PmaBean bean = new PmaBean(pmaId,userName,password);
            pma.add(bean);
        }
        return pma;
    }



    public ArrayList<PmaBean> queryRecord(String password){
        SQLiteDatabase db =getWritableDatabase();
        ArrayList<PmaBean> pma = new ArrayList<PmaBean>();
        Cursor c =db.query("pmar",new String[]{"pmarId","userName","password"},"password=?",new String[]{password},null,null,null);
        //"pmar",new String[]{"userName","password"},"password=?",new String[]{"123456"},null,null,null
        //第二个查询列名凡是要存入javabean的都要写，不然不然找不到列名会报错Couldn’t read row 0, col -1 from CursorWindow
        while (c.moveToNext()){
            pmarId = c.getInt(c.getColumnIndex("pmarId"));
            userName = c.getString(c.getColumnIndex("userName"));
           password = c.getString(c.getColumnIndex("password"));

            PmaBean bean = new PmaBean(pmarId,userName,password);
            pma.add(bean);

        }
        c.close();
      return  pma;//返回null会导致ititerator 无对象
    }
}

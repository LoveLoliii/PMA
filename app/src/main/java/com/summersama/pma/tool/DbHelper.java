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

    public DbHelper(Context context) {
        super(context, "pam.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS pmar"+
        "(pmarId integer primary key autoincrement,"+
        "userName varchar(50),"+
        "password varchar(50))");
        initInsert(db);

    }

    private void initInsert(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

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
        long count = db.insert("pmar",null,values);
        return (int) count;
    }

    public int deleteRecord(int pmarId){
        SQLiteDatabase db = getWritableDatabase();
        int count = db.delete("pmar", pmarId + "=?", new String[]{"" + pmarId});
        return count;
    }
    public ArrayList<PmaBean> queryAll(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c =db.query("pmar", null, null, null, null, null, null);
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



    public PmaBean queryRecord(String password){
        SQLiteDatabase db =getWritableDatabase();
        Cursor c =db.query("pmar",null,password+"=?",new String[]{""+password},null,null,null);
        while (c.moveToNext()){
            int pmaId = c.getInt(c.getColumnIndex("pamId"));
            String userName = c.getString(c.getColumnIndex("userName"));

            PmaBean bean = new PmaBean(pmaId,userName,password);
            return bean;
        }
      return  null;
    }
}

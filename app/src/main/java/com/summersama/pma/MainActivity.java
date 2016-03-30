package com.summersama.pma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.summersama.pma.model.PmarBean;
import com.summersama.pma.tool.DbHelper;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
     EditText metUserName,metPassword;
    DbHelper mDbHelper;
    String userName;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mDbHelper = new DbHelper(this);

        initView();
        setLoginListener();
    }







    private void initView() {
        metUserName= (EditText)findViewById(R.id.UserName);
        metPassword=(EditText)findViewById(R.id.Password);
    }


    private void setLoginListener() {
      MyListener listener= new MyListener(this,metUserName,metPassword);
        findViewById(R.id.LoginBtn).setOnClickListener(listener);
    }
    class MyListener implements View.OnClickListener{
        EditText etUserName,etPassword;
        MainActivity activity;
        public MyListener(MainActivity activity ,EditText etUserName,EditText etPassword){
            this.etUserName = etUserName;
            this.etPassword = etPassword;
            this.activity = activity;
        }

        @Override
        public void onClick(View v) {
            String strUserName = etUserName.getText().toString();
            String strPassword = etPassword.getText().toString();
            if(strUserName==""||strUserName.equals("")){
                etUserName.setError("用户名不为空！！！");
            }

            if(strPassword==""||strPassword.equals("")){
                etPassword.setError("密码不为空！！！");
            }
            Log.i("main", "用户名:" + strUserName + "密码：" + strPassword);

            //查询数据库
           // SQLiteDatabase sqLiteDatabase = mDbHelper.getWritableDatabase();
            // 调用SQLiteDatabase对象的query方法进行查询，返回一个Cursor对象：由数据库查询返回的结果集对象
                    // 第一个参数String：表名
                    // 第二个参数String[]:要查询的列名
                    // 第三个参数String：查询条件
                    // 第四个参数String[]：查询条件的参数
                    // 第五个参数String:对查询的结果进行分组
                    // 第六个参数String：对分组的结果进行限制
                    // 第七个参数String：对查询的结果进行排序

/*            Cursor cursor =sqLiteDatabase.query("pmar",new String[]{"userName","password"},"password=?",new String[]{"123456"},null,null,null);
            while (cursor.moveToNext()){
                userName = cursor.getString(cursor.getColumnIndex("userName"));
                password = cursor.getString(cursor.getColumnIndex("password"));

            }*/
            mDbHelper.getWritableDatabase();
            ArrayList<PmarBean> pma = mDbHelper.queryRecord(strPassword);
            Iterator<PmarBean> it = pma.iterator();

           while (it.hasNext()){
               PmarBean ss =it.next();//若写成 userName=it.next().getUserName ;password =it.next().getPassword()
                                    // 则会报越界错误。java.util.NoSuchElementException
               userName = ss.getUserName();
               password = ss.getPassword();
              if(strUserName.equals(userName)&&strPassword.equals(password)) {
                   Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();


                   Intent intent = new Intent(MainActivity.this, IndexActivity.class);
                   startActivity(intent);
               }
           }
            /*if(strUserName.equals(userName)&&strPassword.equals(password)) {
                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MainActivity.this, IndexActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, userName, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, password, Toast.LENGTH_SHORT).show();
            }*/
            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, userName, Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, password, Toast.LENGTH_SHORT).show();
        }
    }

}

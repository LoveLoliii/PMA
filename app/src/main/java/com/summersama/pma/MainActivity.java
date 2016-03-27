package com.summersama.pma;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText metUserName,metPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // createDataBase();
        initView();
        setLoginListener();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return  true;
    }


    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(MainActivity.this,"点击了Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(MainActivity.this,"点击了Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }


    private void initView() {
        metUserName= (EditText)findViewById(R.id.UserName);
        metPassword=(EditText)findViewById(R.id.Password);
    }

    private void createDataBase() {
         //final String Table_Name= "lytic_table";


        SQLiteDatabase db = openOrCreateDatabase("pma.db",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS pma"+
                "( pmaId integer primary key autoincrement,"+
                "UserName varchar(50),"+
                "Password varchar(50))");

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
            if(strUserName==""||strUserName.equals("")){
                etUserName.setError("用户名不为空！！！");
            }
            String strPassword = etPassword.getText().toString();
            if(strPassword==""||strPassword.equals("")){
                etPassword.setError("密码不为空！！！");
            }
            Log.i("main", "用户名:" + strUserName + "密码：" + strPassword);
            Intent intent = new Intent(MainActivity.this,IndexActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this,"功能尚未完善！",Toast.LENGTH_SHORT).show();


        }
    }

}

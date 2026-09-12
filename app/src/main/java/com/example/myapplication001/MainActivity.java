package com.example.myapplication001;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText editname = findViewById(R.id.name);
        EditText editage = findViewById(R.id.age);
        EditText editphone = findViewById(R.id.phonenumber);
        //找输入框 获得输入框里面的内容
       EditText editusername= findViewById(R.id.username);
        EditText editpasswd= findViewById(R.id.passwd);


//页面一内：按钮一   注册  存数据 去页面三   按钮二  登录 去页面三
        //SharedPreferences sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putString("username", "张三");
        //editor.putString("password", "123456");
        //editor.apply();含义
        //打开文件，返回一个对象，变可读    变成可写可编辑   输入用户名密码   真正存入
        //btn1
        Button btn1 = findViewById(R.id.signup);
        btn1.setOnClickListener(v-> {
                    //获取输入框内文字，转成字符串，赋值给变量，再变成可读，再变可写可编辑，再存入
                    String name = editname.getText().toString();
                    String age = editage.getText().toString();
                    String phone = editphone.getText().toString();
                    String username = editusername.getText().toString();
                    String passwd = editpasswd.getText().toString();

                    SharedPreferences sp = getSharedPreferences("userinfo", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("name", name);
                    editor.putString("age", age);
                    editor.putString("phone", phone);
                    editor.putString("username", username);
                    editor.putString("passwd", passwd);
                    editor.apply();
                    //注册  存数据
                    //进页面三
                    Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                    startActivity(intent);
                });
                //按照“页面一（注册） -> 页面三（登录） -> 页面二（主页）”的路线，
               //注册完去登录  登录完去主页
                //页面1完成  先页面三  再页面2

        //btn2
            Button btn2 =findViewById(R.id.login);
            btn2.setOnClickListener(v->{

                Intent intent1=new Intent(MainActivity.this,ThirdActivity.class);
            startActivity(intent1);

            });







    }

        }





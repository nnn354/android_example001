package com.example.myapplication001;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

//页面2  如果页面3里面登录成功，跳转到页面2
//页面2显示该用户所有信息 并且表示欢迎xxx


public  class SecondActivity extends AppCompatActivity{
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.acti_second);

        //从shared获取信息   赋值给变量  赋值给文本控件
       android.content.SharedPreferences sp =getSharedPreferences("userinfo",MODE_PRIVATE);
       String  name=sp.getString("name","");
       String age=sp.getString("age","");
       String phone=sp.getString("phone","");
       String username=sp.getString("username","");
       String passwd=sp.getString("passwd","");

       //把变量的值赋值给一个控件
        //控件名.setText(变量);
        TextView name1=findViewById(R.id.txt_name);
        TextView age1=findViewById(R.id.txt_age);
        TextView phone1=findViewById(R.id.txt_phone);
        TextView username1=findViewById(R.id.txt_username);
        TextView passwd1=findViewById(R.id.txt_passwd);
        TextView hello1=findViewById(R.id.hello);
        name1.setText(name);
        age1.setText(age);
        phone1.setText(phone);
        username1.setText(username);
        passwd1.setText(passwd);
        hello1.setText("欢迎，姓名："+name+"\n用户名"+username+"\n年龄："+age+"\n电话号码："+phone);

    }
}

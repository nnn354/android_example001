package com.example.myapplication001;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.third_activity);



        //获取页面3输入框里面的内容  从输入框里面得到文本 转成字符串  比对手机号和密码    反应
        // 成功则跳转页面2 失败则弹窗提醒哪一部分失败  是手机号不存在还是密码不正确
        Button logbtn=findViewById(R.id.loginbtn);
        logbtn.setOnClickListener(v->{
            //点击提交按钮后输入框里面才肯定有内容  才能获取
            EditText  logphone=findViewById(R.id.logphone);
            EditText logpasswd=findViewById(R.id.logpasswd);

            String phone=logphone.getText().toString();
            String passwd=logpasswd.getText().toString();

        //从 SharedPreferences 取数据
            SharedPreferences sp=getSharedPreferences("userinfo",MODE_PRIVATE);
            String sharedphone=sp.getString("phone","");
            String sharedpasswd=sp.getString("passwd","");
            //比较是否一致 一样就去页面二，显示用户信息  不一致就弹窗，手机号不存在或者密码错误
            //==：判断两个变量是不是同一个对象（内存地址相同）。
            //
            //equals()：判断两个对象内容是否一样。
            if(phone.equals(sharedphone) && passwd.equals(sharedpasswd)){
                Intent intent =new Intent(ThirdActivity.this,SecondActivity.class);
                startActivity(intent);

            }
            else {
                if(!phone.equals(sharedphone)){
                    Toast.makeText(ThirdActivity.this,"手机号不存在",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ThirdActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
                }
            }





        });

    }
}

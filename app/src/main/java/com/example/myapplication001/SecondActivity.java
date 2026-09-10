package com.example.myapplication001;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.acti_second);
//从页面一获取
        Intent  intent= getIntent();
        String name=intent.getStringExtra("name");
        String age=intent.getStringExtra("age");
        String phone=intent.getStringExtra("phone");
        //在页面二显示出来
        TextView alltext= findViewById(R.id.textall);
        alltext.setText("name:"+name+"\nage:"+age+"\nphone:"+phone);


    }
}

package com.example.myapplication001;

import android.content.Intent;
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

        EditText editname=findViewById(R.id.name);
        EditText editage=findViewById(R.id.age);
        EditText editphone=findViewById(R.id.phonenumber);//找输入框



        Button btnsubmit = findViewById( R.id.btnsubmit);
        btnsubmit.setOnClickListener(v->{
            //把输入框里面的文字赋值给变量
            //从页面一传出数据到页面二
            String name=editname.getText().toString();
            String  age=editage.getText().toString();
            String phone=editphone.getText().toString();

            Intent intent = new Intent(MainActivity.this,SecondActivity.class);

            intent.putExtra("name",name);
            intent.putExtra("age",age);
            intent.putExtra("phone",phone);
            startActivity(intent);
                }

        );//跳转

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
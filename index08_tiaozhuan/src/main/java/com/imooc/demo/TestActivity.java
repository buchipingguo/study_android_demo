package com.imooc.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by renkangke .
 */
public class TestActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity与layout进行了关联
        setContentView(R.layout.activity_test);

        // 通过findViewById将layout中的控件找出来，并转化成View
        final TextView textView = findViewById(R.id.titleTextView);
        // 打到button这个view
        Button button = findViewById(R.id.button);

        // 设置点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 为textView动态设置文本
                textView.setText(getString(R.string.app_name));

                // 跳转到一个NewActivity
                Intent intent = new Intent(TestActivity.this, TestActivity.class);
                startActivity(intent);

            }
        });


    }
}

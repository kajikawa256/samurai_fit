package com.example.samurai_fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // 画面切り替え用のスイッチの処理
        Button myButton1 = findViewById(R.id.button1);
        Button myButton2 = findViewById(R.id.button2);
        Button myButton3 = findViewById(R.id.button3);
        Button myButton4 = findViewById(R.id.button4);

        myButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        myButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Setting.this, Setting.class);
//                startActivity(intent);
            }
        });

        myButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Setting.this, Setting.class);
//                startActivity(intent);
            }
        });

        myButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, Setting.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
package com.example.samurai_fit;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
public class HomeActivity extends AppCompatActivity {
    private CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Imageviewのpadding設定
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setPadding(0,0,0,0);


        //線の座標を判定
        float startX = 100; // 線の開始X座標
        float startY = 100; //線の開始Y座標
        float endX = 300; //線の終了X座標
        float endY = 500; //線の終了Y座標

        customView.setLineCoordinates(startX, startY, endX, endY);
    }
}


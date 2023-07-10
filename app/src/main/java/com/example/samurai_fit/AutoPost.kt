package com.example.samurai_fit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class AutoPost : AppCompatActivity() {
    //自動投稿で表示する配列
    private val postList =arrayOf("投稿1","投稿2","投稿3")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_post)

        // 画面切り替え用のスイッチの処理
        val myButton1 = findViewById<Button>(R.id.button1)
        val myButton2 = findViewById<Button>(R.id.button2)
        val myButton3 = findViewById<Button>(R.id.button3)
        val myButton4 = findViewById<Button>(R.id.button4)
        myButton1.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        myButton2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        myButton3.setOnClickListener {
            //                Intent intent = new Intent(Setting.this, Setting.class);
//                startActivity(intent);
        }
        myButton4.setOnClickListener {
            val intent = Intent(this,Setting::class.java);
               startActivity(intent);
        }
        //画面表示処理
        val containerLayout: LinearLayout = findViewById(R.id.containerLayout)
        for (post in postList) {
            val textView = TextView(this)
            textView.text = post
            containerLayout.addView(textView)
        }

    }
}
package com.example.samurai_fit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 画面切り替え用のスイッチの処理
        val myButton1 = findViewById<Button>(R.id.button1)
        val myButton2 = findViewById<Button>(R.id.button2)
        val myButton3 = findViewById<Button>(R.id.button3)
        val myButton4 = findViewById<Button>(R.id.button4)


        myButton1.setOnClickListener { }
        myButton2.setOnClickListener {
            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intent)
        }
        myButton3.setOnClickListener {
             val intent = Intent(this@HomeActivity, AutoPost::class.java)
             startActivity(intent)
        }
        myButton4.setOnClickListener {
            val intent = Intent(this@HomeActivity, Setting::class.java)
            startActivity(intent)
            finish()
        }
    }
}
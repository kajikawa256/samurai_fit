package com.example.samurai_fit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        // 画面切り替え用のスイッチの処理
        val myButton1 = findViewById<Button>(R.id.button1)
        val myButton2 = findViewById<Button>(R.id.button2)
        val myButton3 = findViewById<Button>(R.id.button3)
        val myButton4 = findViewById<Button>(R.id.button4)
        myButton1.setOnClickListener {
            val intent = Intent(this@Setting, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        myButton2.setOnClickListener {
            val intent = Intent(this@Setting, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        myButton3.setOnClickListener {
            val intent = Intent(this@Setting, AutoPost::class.java)
            startActivity(intent)
            finish()
        }
        myButton4.setOnClickListener {

        }
    }
}
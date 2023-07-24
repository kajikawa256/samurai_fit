package com.example.samurai_fit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        // 設定画面のボタン
        val  notifyBtn = findViewById<Button>(R.id.notifyBtn)

        // ボタンがクリックされたときの処理
        notifyBtn.setOnClickListener {
            val intent = Intent(this@Setting, Notification::class.java)
            startActivity(intent)
        }
        val autopostBtn = findViewById<Button>(R.id.autopostBtn)

        autopostBtn.setOnClickListener{
            val intent = Intent(this@Setting,Set_Autopost::class.java)
            startActivity(intent)
        }

        val goalsBtn = findViewById<Button>(R.id.goalsBtn)

        goalsBtn.setOnClickListener{
            val intent = Intent(this@Setting,TargetActivity::class.java)
            startActivity(intent)
        }

        val loginBtn = findViewById<Button>(R.id.loginBtn)

        loginBtn.setOnClickListener{
            val intent = Intent(this@Setting, LoginActivity::class.java)
            startActivity(intent)
        }


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
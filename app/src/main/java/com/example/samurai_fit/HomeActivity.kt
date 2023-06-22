package com.example.samurai_fit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class HomeActivity : AppCompatActivity() {

    private lateinit var weekTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        weekTextView = findViewById(R.id.weekview)
        val myImageButton = findViewById<ImageButton>(R.id.button5)


        val calendar = Calendar.getInstance()
        val weekNumber = calendar.get(Calendar.WEEK_OF_YEAR)

        val weekText = "週数: $weekNumber"
        weekTextView.text = weekText

        // 画面切り替え用のボタンの処理
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
            // val intent = Intent(this, Setting::class.java)
            // startActivity(intent)
        }
        myButton4.setOnClickListener {
            val intent = Intent(this@HomeActivity, Setting::class.java)
            startActivity(intent)
            finish()
        }

        myImageButton.setOnClickListener {
            // ボタンがクリックされた時の処理をここに記述
            Toast.makeText(applicationContext, "Toastメッセージ", Toast.LENGTH_SHORT).show()
        }

    }
}
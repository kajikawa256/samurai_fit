package com.example.samurai_fit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class Notification : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val myButton = findViewById<ImageButton>(R.id.back)

        myButton.setOnClickListener {
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
            finish()
        }

    }
}
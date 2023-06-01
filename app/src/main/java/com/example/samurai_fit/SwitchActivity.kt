package com.example.samurai_fit

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SwitchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switchvar)

        val myButton = findViewById<Button>(R.id.button1)
        myButton.setOnClickListener {
            Toast.makeText(applicationContext, "ボタンがクリックされました", Toast.LENGTH_SHORT).show()
        }
    }
}

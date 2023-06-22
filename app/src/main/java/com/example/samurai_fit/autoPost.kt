package com.example.samurai_fit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class autoPost : AppCompatActivity() {
    val postList =arrayOf("投稿1","投稿2","投稿3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_post)

        val containerLayout: LinearLayout = findViewById(R.id.containerLayout)
        for (post in postList) {
            val textView = TextView(this)
            textView.text = post
            containerLayout.addView(textView)
        }

    }
}
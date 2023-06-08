package com.example.samurai_fit

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class autPost : AppCompatActivity() {
        private lateinit var postContentTextView: TextView;
        private lateinit var likeButton: Button;
        private lateinit var commentButton: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_aut_post)

        val postContentTextView = findViewById<TextView>(R.id.postContentTextView)
        val likeButton = findViewById<Button>(R.id.likeButton)
        val commentButton = findViewById<Button>(R.id.commentButton)
        likeButton.setOnClickListener {
            // いいねボタンがクリックされた時の処理
            Toast.makeText(this, "いいねが押されました", Toast.LENGTH_SHORT).show()
        }

        commentButton.setOnClickListener {
            // コメントボタンがクリックされた時の処理
            Toast.makeText(this, "コメントが押されました", Toast.LENGTH_SHORT).show()
        }
    }
}
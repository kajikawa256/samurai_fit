package com.example.samurai_fit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val menu: Array<String> = resources.getStringArray(R.array.menu);
        var text: String = menu[0] +  getString(R.string.goal) + menu[1];

        val todaysGoal: TextView = findViewById(R.id.TodaysGoal)
        todaysGoal.text = text;

        menu[0] = "マラソン";
        menu[1] = "分";

        text = menu[0] + getString(R.string.goal) + menu[1];
        todaysGoal.text = todaysGoal.text.toString() + "\n" + text;


        //画面切り替え用のスイッチの処理
        val myButton1 = findViewById<Button>(R.id.button1)
        val myButton2 = findViewById<Button>(R.id.button2)
        val myButton3 = findViewById<Button>(R.id.button3)
        val myButton4 = findViewById<Button>(R.id.button4)

        myButton1.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        myButton2.setOnClickListener {

        }

        myButton3.setOnClickListener {
//            val intent = Intent(this, Setting::class.java)
//            startActivity(intent)
        }

        myButton4.setOnClickListener {
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
            finish()
        }

    }
}
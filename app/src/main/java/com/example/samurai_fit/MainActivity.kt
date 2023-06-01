package com.example.samurai_fit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import com.example.samurai_fit.SwitchActivity

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
      
        val myButton1 = findViewById<Button>(R.id.button1)
        val myButton2 = findViewById<Button>(R.id.button2)
        val myButton3 = findViewById<Button>(R.id.button3)
        val myButton4 = findViewById<Button>(R.id.button4)
        val myButton5 = findViewById<Button>(R.id.button5)

        myButton1.setOnClickListener {
            Toast.makeText(applicationContext, "ボタンがクリックされました", Toast.LENGTH_SHORT).show()
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
        }

        myButton2.setOnClickListener {
            Toast.makeText(applicationContext, "ボタンがクリックされました", Toast.LENGTH_SHORT).show()
        }

        myButton3.setOnClickListener {
            Toast.makeText(applicationContext, "ボタンがクリックされました", Toast.LENGTH_SHORT).show()
        }

        myButton4.setOnClickListener {
            Toast.makeText(applicationContext, "ボタンがクリックされました", Toast.LENGTH_SHORT).show()
        }

        myButton5.setOnClickListener {
            Toast.makeText(applicationContext, "ボタンがクリックされました", Toast.LENGTH_SHORT).show()
        }
    }
}
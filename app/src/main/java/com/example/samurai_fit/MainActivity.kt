package com.example.samurai_fit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

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
    }
}
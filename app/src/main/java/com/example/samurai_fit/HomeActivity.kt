package com.example.samurai_fit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class HomeActivity : AppCompatActivity() {

    private lateinit var weekTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

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

        //壱日目～弐日目
        var Button_one = findViewById<ImageButton>(R.id.button_one)
        var black1_2 = findViewById<ImageView>(R.id.black1_2)
        var red1_2 = findViewById<ImageView>(R.id.red1_2)
        red1_2.visibility = View.GONE
        var isred1: Boolean = true;

        Button_one.setOnClickListener {
            //画像を切り替える
            if(isred1){
                red1_2.visibility = View.VISIBLE
                black1_2.visibility  = View.GONE
                isred1 = false;
            }
        }

        //弐日目～参日目
        var Button_two = findViewById<ImageButton>(R.id.button_two)
        var black2_3 = findViewById<ImageView>(R.id.black2_3)
        var red2_3 = findViewById<ImageView>(R.id.red2_3)
        red2_3.visibility = View.GONE
        var isred2: Boolean = true;

        Button_two.setOnClickListener {
            //画像を切り替える
            if(isred2){
                red2_3.visibility = View.VISIBLE
                black2_3.visibility  = View.GONE
                isred2 = false;
            }
        }

        //参日目～肆日目
        var Button_three = findViewById<ImageButton>(R.id.button_three)
        var black3_4 = findViewById<ImageView>(R.id.black3_4)
        var red3_4 = findViewById<ImageView>(R.id.red3_4)
        red3_4.visibility = View.GONE
        var isred3: Boolean = true;

        Button_three.setOnClickListener {
            //画像を切り替える
            if(isred3){
                red3_4.visibility = View.VISIBLE
                black3_4.visibility  = View.GONE
                isred3 = false;
            }
        }

        //肆日目～伍日目
        var Button_four = findViewById<ImageButton>(R.id.button_four)
        var black4_5 = findViewById<ImageView>(R.id.black4_5)
        var red4_5 = findViewById<ImageView>(R.id.red4_5)
        red4_5.visibility = View.GONE
        var isred4: Boolean = true;

        Button_four.setOnClickListener {
            //画像を切り替える
            if(isred4){
                red4_5.visibility = View.VISIBLE
                black4_5.visibility  = View.GONE
                isred4 = false;
            }
        }

        //伍日目～陸日目
        var Button_five = findViewById<ImageButton>(R.id.button_five)
        var black5_6 = findViewById<ImageView>(R.id.black5_6)
        var red5_6 = findViewById<ImageView>(R.id.red5_6)
        red5_6.visibility = View.GONE
        var isred5: Boolean = true;

        Button_five.setOnClickListener {
            //画像を切り替える
            if(isred5){
                red5_6.visibility = View.VISIBLE
                black5_6.visibility  = View.GONE
                isred5 = false;
            }
        }

        //陸日目～漆日目
        var Button_six = findViewById<ImageButton>(R.id.button_six)
        var black6_7 = findViewById<ImageView>(R.id.black6_7)
        var red6_7 = findViewById<ImageView>(R.id.red6_7)
        red6_7.visibility = View.GONE
        var isred6: Boolean = true;

        Button_six.setOnClickListener {
            //画像を切り替える
            if(isred6){
                red6_7.visibility = View.VISIBLE
                black6_7.visibility  = View.GONE
                isred6 = false;
            }
        }
    }
}
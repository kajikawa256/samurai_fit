package com.example.samurai_fit

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class HomeActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    //週数定義
    private var weekNumber = 0//週数を管理する変数
    private lateinit var weekview: TextView

    //ボタン定義
    private lateinit var Button_one: ImageButton
    private lateinit var Button_two: ImageButton
    private lateinit var Button_three: ImageButton
    private lateinit var Button_four: ImageButton
    private lateinit var Button_five: ImageButton
    private lateinit var Button_six: ImageButton
    private lateinit var Button_seven: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
//        println("onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //ボタン定義
        Button_one = findViewById<ImageButton>(R.id.button_one)
        Button_two = findViewById<ImageButton>(R.id.button_two)
        Button_three = findViewById<ImageButton>(R.id.button_three)
        Button_four = findViewById<ImageButton>(R.id.button_four)
        Button_five = findViewById<ImageButton>(R.id.button_five)
        Button_six = findViewById<ImageButton>(R.id.button_six)
        Button_seven = findViewById<ImageButton>(R.id.button_seven)

        val weekview = findViewById<TextView>(R.id.weekview)

        //黒線定義
        val black1_2 = findViewById<ImageView>(R.id.black1_2)
        val black2_3 = findViewById<ImageView>(R.id.black2_3)
        val black3_4 = findViewById<ImageView>(R.id.black3_4)
        val black4_5 = findViewById<ImageView>(R.id.black4_5)
        val black5_6 = findViewById<ImageView>(R.id.black5_6)
        val black6_7 = findViewById<ImageView>(R.id.black6_7)

        //赤線定義
        val red1_2 = findViewById<ImageView>(R.id.red1_2)
        val red2_3 = findViewById<ImageView>(R.id.red2_3)
        val red3_4 = findViewById<ImageView>(R.id.red3_4)
        val red4_5 = findViewById<ImageView>(R.id.red4_5)
        val red5_6 = findViewById<ImageView>(R.id.red5_6)
        val red6_7 = findViewById<ImageView>(R.id.red6_7)

        //赤線非表示初期定義
        red1_2.visibility = View.GONE
        red2_3.visibility = View.GONE
        red3_4.visibility = View.GONE
        red4_5.visibility = View.GONE
        red5_6.visibility = View.GONE
        red6_7.visibility = View.GONE

        //黒線表示初期定義
        black1_2.visibility = View.VISIBLE
        black2_3.visibility = View.VISIBLE
        black3_4.visibility = View.VISIBLE
        black4_5.visibility = View.VISIBLE
        black5_6.visibility = View.VISIBLE
        black6_7.visibility = View.VISIBLE

        //判定定義
        Button_one.isEnabled = true
        Button_two.isEnabled = false
        Button_three.isEnabled = false
        Button_four.isEnabled = false
        Button_five.isEnabled = false
        Button_six.isEnabled = false
        Button_seven.isEnabled = false

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        loadButtonState() // ボタンの状態を読み込む


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
        Button_one.setOnClickListener {
            //画像を切り替える
            if(Button_one.isEnabled){
                red1_2.visibility = View.VISIBLE
                black1_2.visibility  = View.GONE
            }
            Button_one.isEnabled = false
            Button_two.isEnabled = true

            //保存
            saveButtonState()
        }

        //弐日目～参日目
        Button_two.setOnClickListener {
            //画像を切り替える
            if(Button_two.isEnabled){
                red2_3.visibility = View.VISIBLE
                black2_3.visibility  = View.GONE
            }
            Button_two.isEnabled = false
            Button_three.isEnabled = true

            //保存
            saveButtonState()
        }

        //参日目～肆日目
        Button_three.setOnClickListener {
            //画像を切り替える
            if(Button_three.isEnabled){
                red3_4.visibility = View.VISIBLE
                black3_4.visibility  = View.GONE
            }
            Button_three.isEnabled = false
            Button_four.isEnabled = true

            //保存
            saveButtonState()
        }

        //肆日目～伍日目
        Button_four.setOnClickListener {
            //画像を切り替える
            if(Button_four.isEnabled){
                red4_5.visibility = View.VISIBLE
                black4_5.visibility  = View.GONE
            }
            Button_four.isEnabled = false
            Button_five.isEnabled = true

            //保存
            saveButtonState()
        }

        //伍日目～陸日目
        Button_five.setOnClickListener {
            //画像を切り替える
            if(Button_five.isEnabled){
                red5_6.visibility = View.VISIBLE
                black5_6.visibility  = View.GONE
            }
            Button_five.isEnabled =false
            Button_six.isEnabled = true

            //保存
            saveButtonState()
        }

        //陸日目～漆日目
        Button_six.setOnClickListener {
            //画像を切り替える
            if(Button_six.isEnabled){
                red6_7.visibility = View.VISIBLE
                black6_7.visibility  = View.GONE
            }
            Button_six.isEnabled = false
            Button_seven.isEnabled = true

            //保存
            saveButtonState()
        }

        Button_seven.setOnClickListener {
            if(Button_seven.isEnabled){
                //週数更新　ロードマップリセット
                Button_one.isEnabled = true
                Button_two.isEnabled = false
                Button_three.isEnabled = false
                Button_four.isEnabled = false
                Button_five.isEnabled = false
                Button_six.isEnabled = false
                Button_seven.isEnabled = false

                red1_2.visibility = View.GONE
                red2_3.visibility = View.GONE
                red3_4.visibility = View.GONE
                red4_5.visibility = View.GONE
                red5_6.visibility = View.GONE
                red6_7.visibility = View.GONE

                black1_2.visibility = View.VISIBLE
                black2_3.visibility = View.VISIBLE
                black3_4.visibility = View.VISIBLE
                black4_5.visibility = View.VISIBLE
                black5_6.visibility = View.VISIBLE
                black6_7.visibility = View.VISIBLE

                if(weekNumber > 6){
                    weekNumber = 0
                    weekview.text = "0:週間目"
                }else{
                    weekNumber++
                    weekview.text = "$weekNumber:週間目" //週数を表示するTextViewを更新
                }

                //保存
                saveButtonState()
            }
        }

//        // ボタンの状態をログに出力
//        Log.d("ButtonState", "Button_one: ${Button_one.isEnabled}")
//        Log.d("ButtonState", "Button_two: ${Button_two.isEnabled}")
//        Log.d("ButtonState", "Button_three: ${Button_three.isEnabled}")
//        Log.d("ButtonState", "Button_four: ${Button_four.isEnabled}")
//        Log.d("ButtonState", "Button_five: ${Button_five.isEnabled}")
//        Log.d("ButtonState", "Button_six: ${Button_six.isEnabled}")
    }

    //保存メソッド
    private fun saveButtonState() {
//        println("save")
        val editor = sharedPreferences.edit()
//        println("1:" + Button_one.isEnabled)
//        println("2:" + Button_two.isEnabled)
//        println("3:" + Button_three.isEnabled)
//        println("4:" + Button_four.isEnabled)
//        println("5:" + Button_five.isEnabled)
//        println("6:" + Button_six.isEnabled)
//        println("7:" + Button_seven.isEnabled)

        editor.putBoolean("Button_one", Button_one.isEnabled)
        editor.putBoolean("Button_two", Button_two.isEnabled)
        editor.putBoolean("Button_three", Button_three.isEnabled)
        editor.putBoolean("Button_four", Button_four.isEnabled)
        editor.putBoolean("Button_five", Button_five.isEnabled)
        editor.putBoolean("Button_six", Button_six.isEnabled)
        editor.putBoolean("Button_seven", Button_seven.isEnabled)
        editor.putInt("weekview",weekNumber)
        editor.apply()
    }

    //読み込みメソッド
    private fun loadButtonState() {
//        println("load")
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//        println(sharedPreferences)
        //ボタン定義
        Button_one = findViewById<ImageButton>(R.id.button_one)
        Button_two = findViewById<ImageButton>(R.id.button_two)
        Button_three = findViewById<ImageButton>(R.id.button_three)
        Button_four = findViewById<ImageButton>(R.id.button_four)
        Button_five = findViewById<ImageButton>(R.id.button_five)
        Button_six = findViewById<ImageButton>(R.id.button_six)
        Button_seven = findViewById<ImageButton>(R.id.button_seven)
        //黒線定義
        val black1_2 = findViewById<ImageView>(R.id.black1_2)
        val black2_3 = findViewById<ImageView>(R.id.black2_3)
        val black3_4 = findViewById<ImageView>(R.id.black3_4)
        val black4_5 = findViewById<ImageView>(R.id.black4_5)
        val black5_6 = findViewById<ImageView>(R.id.black5_6)
        val black6_7 = findViewById<ImageView>(R.id.black6_7)

        //赤線定義
        val red1_2 = findViewById<ImageView>(R.id.red1_2)
        val red2_3 = findViewById<ImageView>(R.id.red2_3)
        val red3_4 = findViewById<ImageView>(R.id.red3_4)
        val red4_5 = findViewById<ImageView>(R.id.red4_5)
        val red5_6 = findViewById<ImageView>(R.id.red5_6)
        val red6_7 = findViewById<ImageView>(R.id.red6_7)

        val weekview = findViewById<TextView>(R.id.weekview)

        Button_one.isEnabled = sharedPreferences.getBoolean("Button_one", true)
        Button_two.isEnabled = sharedPreferences.getBoolean("Button_two", true)
        Button_three.isEnabled = sharedPreferences.getBoolean("Button_three", true)
        Button_four.isEnabled = sharedPreferences.getBoolean("Button_four", true)
        Button_five.isEnabled = sharedPreferences.getBoolean("Button_five", true)
        Button_six.isEnabled = sharedPreferences.getBoolean("Button_six", true)
        Button_seven.isEnabled = sharedPreferences.getBoolean("Button_seven", true)
        weekNumber = sharedPreferences.getInt("weekview",0);

        //Button_seven.isEnabled = sharedPreferences.getBoolean("Button_seven", false)
//        println("pre1:" + sharedPreferences.getBoolean("Button_one", true))
//        println("pre2:" + sharedPreferences.getBoolean("Button_two", true))
//        println("pre3:" + sharedPreferences.getBoolean("Button_three", true))
//        println("pre4:" + sharedPreferences.getBoolean("Button_four", true))
//        println("pre5:" + sharedPreferences.getBoolean("Button_five", true))
//        println("pre6:" + sharedPreferences.getBoolean("Button_six", true))
//        println("pre7:" + sharedPreferences.getBoolean("Button_seven", true))
//
//
//        println("load1:" + Button_one.isEnabled)
//        println("load2:" + Button_two.isEnabled)
//        println("load3:" + Button_three.isEnabled)
//        println("load4:" + Button_four.isEnabled)
//        println("load5:" + Button_five.isEnabled)
//        println("load6:" + Button_six.isEnabled)
//        println("load7:" + Button_seven.isEnabled)

        if(Button_one.isEnabled){
            Button_one.isEnabled = true
            Button_two.isEnabled = false
            Button_three.isEnabled = false
            Button_four.isEnabled = false
            Button_five.isEnabled = false
            Button_six.isEnabled = false
            Button_seven.isEnabled = false
        }

        if(Button_two.isEnabled){
            red1_2.visibility = View.VISIBLE
            black1_2.visibility  = View.GONE
            Button_one.isEnabled = false
            Button_two.isEnabled = true
        }
        if(Button_three.isEnabled){
            red1_2.visibility = View.VISIBLE
            black1_2.visibility  = View.GONE
            red2_3.visibility = View.VISIBLE
            black2_3.visibility  = View.GONE
            Button_one.isEnabled = false
            Button_three.isEnabled = true
        }

        if(Button_four.isEnabled){
            red1_2.visibility = View.VISIBLE
            black1_2.visibility  = View.GONE
            red2_3.visibility = View.VISIBLE
            black2_3.visibility  = View.GONE
            red3_4.visibility = View.VISIBLE
            black3_4.visibility  = View.GONE
            Button_one.isEnabled = false
            Button_four.isEnabled = true
        }

        if(Button_five.isEnabled){
            red1_2.visibility = View.VISIBLE
            black1_2.visibility  = View.GONE
            red2_3.visibility = View.VISIBLE
            black2_3.visibility  = View.GONE
            red3_4.visibility = View.VISIBLE
            black3_4.visibility  = View.GONE
            red4_5.visibility = View.VISIBLE
            black4_5.visibility  = View.GONE
            Button_one.isEnabled = false
            Button_five.isEnabled = true
        }

        if(Button_six.isEnabled){
            red1_2.visibility = View.VISIBLE
            black1_2.visibility  = View.GONE
            red2_3.visibility = View.VISIBLE
            black2_3.visibility  = View.GONE
            red3_4.visibility = View.VISIBLE
            black3_4.visibility  = View.GONE
            red4_5.visibility = View.VISIBLE
            black4_5.visibility  = View.GONE
            red5_6.visibility = View.VISIBLE
            black5_6.visibility  = View.GONE
            Button_one.isEnabled = false
            Button_six.isEnabled = true
        }

        if(Button_seven.isEnabled){
            red1_2.visibility = View.VISIBLE
            black1_2.visibility  = View.GONE
            red2_3.visibility = View.VISIBLE
            black2_3.visibility  = View.GONE
            red3_4.visibility = View.VISIBLE
            black3_4.visibility  = View.GONE
            red4_5.visibility = View.VISIBLE
            black4_5.visibility  = View.GONE
            red5_6.visibility = View.VISIBLE
            black5_6.visibility  = View.GONE
            red6_7.visibility = View.VISIBLE
            black6_7.visibility  = View.GONE
            Button_one.isEnabled = false
            Button_seven.isEnabled = true
        }
        weekview.text = "$weekNumber:週間目" //週数を表示するTextViewを更新
    }
}
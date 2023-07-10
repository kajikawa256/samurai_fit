package com.example.samurai_fit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.util.Timer
import java.util.TimerTask


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            毎日、日替わりの運動を表示する。
            ランダムで値を取得し、それに対応した運動を表示する。✓
            運動内容はアプリを更新しても変更されないようにする
            更新タイミングは日付変更直後
         */

        // 現在の日付を取得
        var currentDate = LocalDate.now()

        // タイマータスクを作成
        val timer = Timer()

        // 1秒ごとに日付をチェックするタスクを実行
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val now = LocalDate.now()

                if (now != currentDate) {
                    // 日付が変わった場合の処理
                    currentDate = now
                    // Textviewを探してくる
                    val todaysGoal: TextView = findViewById(R.id.TodaysGoal)

                    // 運動内容
                    val hardExercise: Array<String> = resources.getStringArray(R.array.hardExercise)
                    val softExercise: Array<String> = resources.getStringArray(R.array.softExercise)

                    // 一日の運動をランダムで取得する
                    val hardRandom = (0..hardExercise.size).random()
                    val softRandom = (0..softExercise.size).random()

                    // textに運動内容を入力
                    val hard: String = hardExercise[hardRandom]
                    val soft: String = softExercise[softRandom]

                    todaysGoal.text = "$hard\n$soft\n 水分補給 2L" // textviewに代入
                }
            }
        }, 0, 1000)







        /*
        ----------------------------------   ↓↓共通処理↓↓    ------------------------------------------------------------------
                 */


        //画面切り替え用のスイッチの処理
        val myButton1 = findViewById<Button>(R.id.button1)
        val myButton2 = findViewById<Button>(R.id.button2)
        val myButton3 = findViewById<Button>(R.id.button3)
        val myButton4 = findViewById<Button>(R.id.button4)

        // ホーム画面への遷移 button
        myButton1.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // ページ再度読み込み button
        myButton2.setOnClickListener {

        }

        // 掲示板画面への遷移 button
        myButton3.setOnClickListener {
//            val intent = Intent(this, Setting::class.java)
//            startActivity(intent)
        }

        // 設定画面への遷移 button
        myButton4.setOnClickListener {
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
            finish()
        }

    }
}


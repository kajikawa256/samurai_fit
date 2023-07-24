package com.example.samurai_fit


import android.app.AlarmManager
import android.app.PendingIntent
import android.app.PendingIntent.getBroadcast
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class Notification : AppCompatActivity() {

    private lateinit var timetext: EditText

    private var h = 25;
    private var m = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)


        timetext = findViewById(R.id.editText)

        timetext.setOnClickListener(View.OnClickListener {
            showTimePickerDialog()
        })

        var alarmButton = findViewById<Button>(R.id.almBtn)

        alarmButton.setOnClickListener(View.OnClickListener {

            // Set the alarm to start at 8:30 a.m.
            val calendar: Calendar = Calendar.getInstance().apply {
                timeInMillis = System.currentTimeMillis()
                set(Calendar.HOUR_OF_DAY, h)
                set(Calendar.MINUTE, m)
                set(Calendar.SECOND, 0)
            }

            //BRを指定する
            val intent = Intent(
                applicationContext,
                AlarmReceiver::class.java
            )
            val pending = getBroadcast(
                applicationContext, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            if (h != 25){
                // アラームをセットする
                val am = getSystemService(ALARM_SERVICE) as AlarmManager
                am.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pending)

                Toast.makeText(this, "アラームを"+ h + "時" + m + "分に設定しました", Toast.LENGTH_SHORT).show()
                finishAndRemoveTask()
            }else{
                Toast.makeText(this, "時間を設定してください", Toast.LENGTH_SHORT).show()
            }
        })




    }
    /* 時間ダーダイアログを開くためのメソッド */
    private fun showTimePickerDialog() {
        val calendar: Calendar = Calendar.getInstance()

        val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            h = hour
            cal.set(Calendar.MINUTE, minute)
            m = minute
            //EditTextに選択された時間を設定
            timetext.setText(SimpleDateFormat("HH:mm").format(cal.time))
        }

        //タイムピッカーダイアログを生成および設定
        TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()

    }
}
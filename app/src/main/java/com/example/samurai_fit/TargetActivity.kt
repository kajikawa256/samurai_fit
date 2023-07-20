package com.example.samurai_fit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class TargetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)

        val loadBar = findViewById<SeekBar>(R.id.seekBar)

        loadBar.max = 30
        loadBar.progress = 10

        val numText = findViewById<TextView>(R.id.LoadNum)

        numText.text = loadBar.progress.toString()

        loadBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    numText.text = loadBar.progress.toString()
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            }
        )
    }
}
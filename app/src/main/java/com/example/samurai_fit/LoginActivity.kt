package com.example.samurai_fit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val addressView = findViewById<TextView>(R.id.addressText)
        val addressEdit = findViewById<EditText>(R.id.addressEditText)

        addressEdit.onFocusChangeListener = View.OnFocusChangeListener {view,hasFocus ->
            if (hasFocus){
                addressView.text = getString(R.string.address)
                addressEdit.hint = ""
            }else{
                if (addressEdit.text.isNullOrEmpty()) {
                    addressView.text = ""
                    addressEdit.hint = getString(R.string.address)
                }
            }
        }

        val passView = findViewById<TextView>(R.id.passText)
        val passEdit = findViewById<EditText>(R.id.passEditText)

        passEdit.onFocusChangeListener = View.OnFocusChangeListener {view,hasFocus ->
            if (hasFocus){
                passView.text = getString(R.string.password)
                passEdit.hint = ""
            }else{
                if (passEdit.text.isNullOrEmpty()){
                    passView.text = ""
                    passEdit.hint = getString(R.string.password)
                }
            }
        }

        val logBtn = findViewById<Button>(R.id.logBtn)

        logBtn.setOnClickListener {
            finish()
        }
    }


}
package com.example.midtermexam_nika_kakhniashvili

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AccountActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        initSharedPreference()
        listeners()
    }

    private fun listeners() {
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun initSharedPreference() {
        sharedPreferences = getSharedPreferences("sharedPreference", Context.MODE_PRIVATE)
        val sharedString = sharedPreferences.getString("name", "")
        val textView = findViewById<TextView>(R.id.textView)
        if (sharedString == "") {
            textView.text = "Hello"
        }else  {
            textView.text = "Hello, ${sharedString}"
        }
    }
}
package com.example.midtermexam_nika_kakhniashvili

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LogInActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSharePreference()
        listeners()
    }

    private fun initSharePreference() {
        sharedPreferences = getSharedPreferences("sharedPreference", Context.MODE_PRIVATE)
    }

    private fun listeners() {
        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            val editText = findViewById<EditText>(R.id.EnterYourName)
            if (editText.text.isEmpty()) {
                val intent = Intent(this, AccountActivity::class.java)
                startActivity(intent)
            }else {
                val intent = Intent(this, AccountActivity::class.java)
                val editor = sharedPreferences.edit()
                editor.putString("name", editText.text.toString()).apply()
                startActivity(intent)
                editText.setText("")
            }
        }

        val accountButton = findViewById<Button>(R.id.accountButton)
        accountButton.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
        }
    }
}
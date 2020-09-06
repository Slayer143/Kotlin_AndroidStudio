package com.example.task_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.concatenate)

        button.setOnClickListener{
            val firstInp = findViewById<EditText>(R.id.firstString).text.toString()
            val secondInp = findViewById<EditText>(R.id.secondString).text.toString()

            val output = firstInp + secondInp

            val intent = Intent(this,ResultActivity::class.java)

            intent.putExtra("RESULT", output)

            startActivity(intent)
        }
    }
}
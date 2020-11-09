package com.example.pratice_60

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    companion object {
        const val RESULT = "RESULT"
    }

    private lateinit var result: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.resultBlock)

        val button = findViewById<Button>(R.id.calculateButton)

        if(savedInstanceState != null) result.text = savedInstanceState.getString(RESULT)

        button.setOnClickListener{
            val valA = findViewById<EditText>(R.id.aValue).text.toString()
            val valB = findViewById<EditText>(R.id.bValue).text.toString()
            val valC = findViewById<EditText>(R.id.cValue).text.toString()

            if(valA.toIntOrNull() != null && valB.toIntOrNull() != null && valC.toIntOrNull() != null) {
                result.text = QuadraticEquationCalculator(
                    valA.toInt() - "0".toInt(),
                    valB.toInt() - "0".toInt(),
                    valC.toInt() - "0".toInt()).calculateResult()
            }
            else result.text = "Incorrect input"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if(result.text != "") outState.putString(RESULT, result.text.toString())
    }
}
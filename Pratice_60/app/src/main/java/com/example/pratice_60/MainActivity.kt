package com.example.pratice_60

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.math.pow
import kotlin.math.sqrt

@Database(entities = [CalculatorDataClass::class], version = 2)
abstract class CalculatorDatabase:RoomDatabase(){
    abstract fun calculatorDao():CalculatorDao
}

class MainActivity : AppCompatActivity() {
    companion object {
        const val RESULT = "RESULT"
        lateinit var db: CalculatorDatabase
    }

    private lateinit var result: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(applicationContext, CalculatorDatabase::class.java, "CalculatorDataClass").build()

        result = findViewById(R.id.resultBlock)

        if(savedInstanceState != null) result.text = savedInstanceState.getString(RESULT)

        calculateButton.setOnClickListener{
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

            insertRawToDB(valA, valB, valC, result.text.toString())

            sendButton.visibility = View.VISIBLE
        }

        sendButton.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, result.text)
            intent.type = "text/plain"
            startActivity(intent)
        }
    }

    private fun insertRawToDB(
        valA: String,
        valB: String,
        valC: String,
        res: String
    ){
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){
                db.calculatorDao().insertResult(CalculatorDataClass(0, valA, valB, valC, res))
            }
        }
    }

    override fun onStart() {
            super.onStart()

        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){
                val res = db.calculatorDao().getLastResult()

                if(res != null){
                    previousA.visibility = View.VISIBLE
                    previousA.text = "Previous A: " + res.valA.toString()

                    previousB.visibility = View.VISIBLE
                    previousB.text = "Previous B: " + res.valB.toString()

                    previousC.visibility = View.VISIBLE
                    previousC.text = "Previous C: " + res.valC.toString()

                    result.text = "Previous result: " + res.res.toString()
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if(result.text != "") outState.putString(RESULT, result.text.toString())
    }
}
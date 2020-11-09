package com.example.practice_90

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.math.BigInteger
import java.util.*
import kotlin.math.log

class CalculatingLogic private constructor(private var activity: MainActivity?,
                                           private val coroutine: CoroutineScope = CoroutineScope(Dispatchers.Main)){
    private fun calculateFactorial(num: Int): String{
        var factorialRes = BigInteger("1")

        for(i in 2..num){
            factorialRes = factorialRes.multiply(i.toBigInteger())
        }

        return factorialRes.toString()
    }

    var result: String? = null

    fun launchCoroutine(){
        coroutine.launch{
            var res = ""

            withContext(Dispatchers.Default){
                res = calculateFactorial(activity?.numberInput?.text.toString().toInt())
            }

            activity?.showResult(res)

            result = res
        }
    }

    fun cancelCoroutine(){
        if(coroutine.isActive) coroutine.cancel()
    }

    fun free(){
        activity = null
    }

    fun setActivity(main: MainActivity){
        activity = main
    }

    companion object{

        private var logic: CalculatingLogic? = null

        fun getInstance(activity: MainActivity?): CalculatingLogic{
            if(logic == null) logic = CalculatingLogic(activity)
            else logic!!.activity = activity
            return logic!!
        }
    }
}

class MainActivity : AppCompatActivity() {
    private val logic = CalculatingLogic.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = logic.result
        if(result != null) showResult(result)

        startCalculate.setOnClickListener {
            logic.launchCoroutine()
        }

        stopCalculate.setOnClickListener {
            logic.cancelCoroutine()
        }
    }

    fun showResult(res: String){
        factorial.text = res
    }

    override fun onResume() {
        super.onResume()

        logic.setActivity(this)
    }

    override fun onPause() {
        super.onPause()

        logic.free()
    }
}
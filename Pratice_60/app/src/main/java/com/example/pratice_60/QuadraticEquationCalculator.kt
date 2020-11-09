package com.example.pratice_60

import kotlin.math.pow
import kotlin.math.sqrt

class QuadraticEquationCalculator(
    private val convertedValA: Int,
    private  val convertedValB: Int,
    private val convertedValC: Int) {

    fun calculateResult(): String{
        if (convertedValA != 0 && convertedValB != 0 && convertedValC != 0){
            return discriminantCase()
        }
        else if(convertedValA != 0 && convertedValB == 0 && convertedValC != 0){
            return withoutBValueCase()
        }
        else if(convertedValA != 0 && convertedValB != 0 && convertedValC == 0)
            return "first x = 0; second x = ${-1 * convertedValB / convertedValA}"
        else if(convertedValA != 0 && convertedValB == 0 && convertedValC == 0)
            return "x = 0"

        return "x - any number"
    }

    fun discriminantCase(): String{
        val discriminant = calculateDiscriminant()

        return when {
            discriminant == 0 -> "x = ${(-1 * convertedValB + sqrt(discriminant.toDouble())).toInt() / (2 * convertedValA)}"
            discriminant > 0 -> "first x = ${(-1 * convertedValB + sqrt(discriminant.toDouble())).toInt() / (2 * convertedValA)}; " +
                    "second x = ${(-1 * convertedValB - sqrt(discriminant.toDouble())).toInt() / (2 * convertedValA)}"
            else -> "No solutions with entered values"
        }
    }

    fun calculateDiscriminant(): Int{
       return (convertedValB.toDouble().pow(2.0) - 4 * convertedValA * convertedValC).toInt()
    }

    fun withoutBValueCase(): String{
        return if(-1 * convertedValC / convertedValA < 0) "No squares;"
        else "x = +/-${sqrt((-1 * (convertedValC/ convertedValA)).toDouble()).toInt()}"
    }
}
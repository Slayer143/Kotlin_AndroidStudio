package com.example.pratice_60

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.sqrt

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class QuadraticEquationCalculatorUnitTest {
    @Test
    fun calculateDiscriminant_isCorrect() {
        assertEquals(16, QuadraticEquationCalculator(1, -2, -3).calculateDiscriminant())
        assertEquals(-131, QuadraticEquationCalculator(5, 3, 7).calculateDiscriminant())
        assertEquals(0, QuadraticEquationCalculator(1, -6, 9).calculateDiscriminant())
    }

    @Test
    fun discriminantCase_isCorrect(){
        assertEquals("first x = 3; second x = -1", QuadraticEquationCalculator(1, -2, -3).discriminantCase())
        assertEquals("No solutions with entered values", QuadraticEquationCalculator(5, 3, 7).discriminantCase())
        assertEquals("x = 3", QuadraticEquationCalculator(1, -6, 9).discriminantCase())
    }

    @Test
    fun calculateResult_isCorrect(){
        assertEquals("first x = 0; second x = 7", QuadraticEquationCalculator(1, -7, 0).calculateResult())
        assertEquals("first x = -5; second x = 3", QuadraticEquationCalculator(-1, -2, 15).calculateResult())
        assertEquals("x = -6", QuadraticEquationCalculator(1, 12, 36).calculateResult())
    }

    @Test
    fun withoutBValueCase_isCorrect(){
        assertEquals("No squares;", QuadraticEquationCalculator(5, 0, 30).withoutBValueCase())
        assertEquals("x = +/-1", QuadraticEquationCalculator(4, 0, -9).withoutBValueCase())
        assertEquals("No squares;", QuadraticEquationCalculator(2, 0, 10).withoutBValueCase())
    }
}
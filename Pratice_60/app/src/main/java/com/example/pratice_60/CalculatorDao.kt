package com.example.pratice_60

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CalculatorDao{
    @Query("SELECT * FROM CalculatorDataClass WHERE rawId = (SELECT MAX(rawId) FROM CalculatorDataClass)")
    fun getLastResult(): CalculatorDataClass

    @Insert
    fun insertResult(calculatorDataClass: CalculatorDataClass)
}


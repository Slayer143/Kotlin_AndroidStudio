package com.example.pratice_60

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CalculatorDataClass(
    @PrimaryKey(autoGenerate = true) val rawId: Int = 0,
    @ColumnInfo(name = "valA") val valA: String?,
    @ColumnInfo(name = "valB") val valB: String?,
    @ColumnInfo(name = "valC") val valC: String?,
    @ColumnInfo(name = "res") val res: String?)

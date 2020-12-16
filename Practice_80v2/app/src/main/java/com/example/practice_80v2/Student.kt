package com.example.practice_80v2

import android.graphics.Bitmap
import java.io.Serializable

data class Student (
    private var name: String,
    private var lastName: String,
    private var secondName: String,
    private var gender: Char,
    private var age: Int,
    private var photo: z?): Serializable  {
    fun changeStudentInfo(
        newName: String,
        newLastName: String,
        newSecondName: String,
        newGender: Char,
        newAge: String,
        newPhoto: Bitmap?
    ) {
        if (newName != " ")
            name = newName

        if (newLastName != " ")
            lastName = newLastName

        if (newSecondName != " ")
            secondName = newSecondName

        if (newGender != ' ')
            gender = newGender

        if (newAge.toIntOrNull() != null) {
            if (newAge.toInt() != 0
                && newAge.toInt() < 30
                && newAge.toInt() > 15
            )
                age = newAge.toInt()
        }

        if (newPhoto != null)
            photo = newPhoto
    }

    fun writeOutStudent(): String{
        return "Last name: ${this.lastName}" +
                "Name: ${this.name}" +
                "Second name: ${this.secondName}" +
                "Gender: ${this.gender}" +
                "Age: ${this.age};"
    }

    fun getPhoto(): Bitmap?{
        return this.photo
    }

    fun getField(fieldNum: String): String{
        return when(fieldNum){
            "1" -> { this.lastName }
            "2" -> { this.name }
            "3" -> { this.secondName }
            "4" -> { this.gender.toString() }
            "5" -> { this.age.toString() }
            else -> { this.lastName }
        }
    }
}
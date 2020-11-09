package com.example.practice_80

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val addButton = findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.name).text.toString()
            val lastName = findViewById<EditText>(R.id.lastName).text.toString()
            val secondName = findViewById<EditText>(R.id.secondName).text.toString()
            val gender = findViewById<Spinner>(R.id.genderSpinner).selectedItem.toString()
            val age = findViewById<EditText>(R.id.age).text.toString()

            if(name != ""
                && lastName != ""
                && secondName != ""
                && gender != ""
                && age != ""
                && age.toIntOrNull() != null){
                val student = Student(name, lastName, secondName, gender[0], age.toInt())

                val intent = Intent(this, MainActivity::class.java)

                intent.putExtra("STUDENT", student)

                startActivity(intent)
            }
        }
    }
}
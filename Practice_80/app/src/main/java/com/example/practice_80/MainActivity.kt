package com.example.practice_80

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val storage = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(intent.hasExtra("STUDENT"))
            storage.add(intent.getSerializableExtra("STUDENT") as Student)

        val addStudentButton = findViewById<Button>(R.id.addStudentButton)

        addStudentButton.setOnClickListener{
            val intent = Intent(this, AddStudentActivity::class.java)

            startActivity(intent)
        }

        val changeInfoButton = findViewById<Button>(R.id.changeInfoButton)



        val deleteStudentButton = findViewById<Button>(R.id.deleteStudentButton)



        val sortStudentButton = findViewById<Button>(R.id.sortStudentsButton)



        val findStudentButton = findViewById<Button>(R.id.findStudentButton)



        val sortStudentsButton = findViewById<Button>(R.id.showDataButton)

    }
}
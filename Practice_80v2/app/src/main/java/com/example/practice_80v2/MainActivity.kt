package com.example.practice_80v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val STUDENTS_STORAGE = "STORAGE"
        private var storage = ArrayList<Student>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addStudentButton = findViewById<Button>(R.id.addStudentButton)

        addStudentButton.setOnClickListener{
            val adding = Intent(this, AddStudentActivity::class.java)

            startActivityForResult(adding, AddStudentActivity.GET_INFO)
        }

        val showStudentsButton = findViewById<Button>(R.id.showDataButton)

        showStudentsButton.setOnClickListener{
            val showing = Intent(this, ShowStudentsActivity::class.java)

            showing.putExtra(STUDENTS_STORAGE, storage)

            startActivityForResult(showing, ShowStudentsActivity.GET_INFO)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data != null){
            if(resultCode == AddStudentActivity.GET_INFO){
                val student = data.getSerializableExtra(AddStudentActivity.STRING_STUDENT) as Student
                storage.add(student)
            }
            if(resultCode == ShowStudentsActivity.GET_INFO){
                storage = data.getSerializableExtra(ShowStudentsActivity.STUDENTS) as ArrayList<Student>
            }
        }
    }
}
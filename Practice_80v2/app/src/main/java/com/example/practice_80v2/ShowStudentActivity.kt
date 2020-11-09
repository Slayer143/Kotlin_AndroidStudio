package com.example.practice_80v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_show_student.*
import kotlinx.android.synthetic.main.students_layout.*
import kotlinx.android.synthetic.main.students_layout.ageShowModule
import kotlinx.android.synthetic.main.students_layout.genderShowModule
import kotlinx.android.synthetic.main.students_layout.lastNameShowModule
import kotlinx.android.synthetic.main.students_layout.nameShowModule
import kotlinx.android.synthetic.main.students_layout.secondNameShowModule

class ShowStudentActivity : AppCompatActivity() {
    companion object{
        const val GET_INFO = 3
        const val STUDENTS = "STUDENTS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_student)

        var isEditActionChosen = false

        val student = intent.getSerializableExtra(ShowStudentsActivity.STUDENT) as Student

        val students = intent.getSerializableExtra(ShowStudentsActivity.STUDENTS) as ArrayList<Student>

        nameShowModule.text = "Name:" + student.getField("2")
        lastNameShowModule.text = "Last name:" + student.getField("1")
        secondNameShowModule.text = "Second name:" + student.getField("3")
        genderShowModule.text = "Gender:" + student.getField("4")
        ageShowModule.text = "Age:" + student.getField("5")

        changeInfoButton.setOnClickListener {
            visibilityControl(View.VISIBLE)
            isEditActionChosen = true
        }

        deleteStudentButton.setOnClickListener {
            visibilityControl(View.GONE)
            isEditActionChosen = false
        }

        submitButton.setOnClickListener{
            if(!isEditActionChosen)
                students.remove(student)
            else if(isEditActionChosen
                && nameEditModule.text.toString() != ""
                && lastNameEditModule.text.toString() != ""
                && secondNameEditModule.text.toString() != ""
                && genderSpinner.selectedItem.toString() != ""
                && ageEditModule.text.toString() != ""
                && ageEditModule.text.toString().toIntOrNull() != null){
                val newInfo = Student(nameEditModule.text.toString(),
                    lastNameEditModule.text.toString(),
                    secondNameEditModule.text.toString(),
                    genderSpinner.selectedItem.toString()[0],
                    ageEditModule.text.toString().toInt())

                students.find { it == student }?.changeStudentInfo(
                    newInfo.getField("2"),
                    newInfo.getField("1"),
                    newInfo.getField("3"),
                    newInfo.getField("4")[0],
                    newInfo.getField("5"))
            }

            val intent = Intent()

            intent.putExtra(STUDENTS, students)

            setResult(GET_INFO, intent)
            finish()
        }
    }

    private fun visibilityControl(visibility: Int){
        name.visibility = visibility
        lastName.visibility = visibility
        secondName.visibility = visibility
        genderChoose.visibility = visibility
        age.visibility = visibility
        nameEditModule.visibility =  visibility
        lastNameEditModule.visibility = visibility
        secondNameEditModule.visibility = visibility
        genderSpinner.visibility = visibility
        ageEditModule.visibility = visibility
        submitButton.visibility = View.VISIBLE
    }
}
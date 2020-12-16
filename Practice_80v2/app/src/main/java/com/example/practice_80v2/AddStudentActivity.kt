package com.example.practice_80v2

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_add_student.*

class AddStudentActivity : AppCompatActivity() {
    companion object {
        const val GET_INFO = 1
        const val STRING_STUDENT = "STUDENT"
        const val GET_PHOTO = 2
        lateinit var photo : Bitmap
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val addButton = findViewById<Button>(R.id.addButton)

        photoButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(intent, GET_PHOTO);
        }

        addButton.setOnClickListener {
            val name = this.name.text.toString()
            val lastName = this.lastName.text.toString()
            val secondName = this.secondName.text.toString()
            val gender = this.genderSpinner.selectedItem.toString()
            val age = this.age.text.toString()

            if (name != ""
                && lastName != ""
                && secondName != ""
                && gender != ""
                && age != ""
                && age.toIntOrNull() != null
                && photo != null
            ) {
                val student = Student(name, lastName, secondName, gender[0], age.toInt(), photo)

                val intent = Intent()

                intent.putExtra(STRING_STUDENT, student)

                setResult(GET_INFO, intent)
                finish()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GET_PHOTO && data != null) {
            if (resultCode == RESULT_OK) {
                photo = data.extras?.get("data") as Bitmap
            }
        }
    }
}
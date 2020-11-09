package com.example.practice_80v2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_show_students.*
import kotlinx.android.synthetic.main.students_layout.view.*

class ShowStudentsActivity : AppCompatActivity() {
    companion object{
        const val GET_INFO = 2
        const val STUDENTS = "STUDENTS"
        const val STUDENT = "STUDENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_students)

        val students = intent.getSerializableExtra(MainActivity.STUDENTS_STORAGE) as ArrayList<Student>

        applyList(students, LinearLayoutManager(this))

        filterButton.setOnClickListener{
            val sortedStudents = ArrayList<Student>(students.sortedBy { it.getField(getField()) })

            applyList(sortedStudents, LinearLayoutManager(this))
        }

        searchButton.setOnClickListener{
            val foundStudents = ArrayList<Student>(students.filter { it.getField(getField()).contains(finderField.text.toString()) })

            applyList(foundStudents, LinearLayoutManager(this))
        }
    }

    private fun getField(): String{
        return when(searchSpinner.selectedItem.toString()){
            "Name" -> {
                "2"
            }
            "Last name" -> {
                "1"
            }
            "Second name" -> {
                "3"
            }
            "Gender" -> {
                "4"
            }
            else -> {
                "5"
            }
        }
    }

    private fun applyList(usedList: ArrayList<Student>, viewManager: RecyclerView.LayoutManager){
        val viewAdapter = StudentsAdapter(usedList, this)

        studentsRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    class StudentsAdapter(private val dataset: ArrayList<Student>, private val activity: ShowStudentsActivity): RecyclerView.Adapter<StudentsAdapter.StudentViewHolder>(){
        class StudentViewHolder(val view: View): RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.students_layout, parent, false)
            return StudentViewHolder(view)
        }

        override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
            holder.view.nameShowModule.text = "Name: " + dataset[position].getField("2")
            holder.view.lastNameShowModule.text = "Last name: " +  dataset[position].getField("1")
            holder.view.secondNameShowModule.text = "Second name: " + dataset[position].getField("3")
            holder.view.genderShowModule.text = "Gender: " + dataset[position].getField("4")
            holder.view.ageShowModule.text = "Age: " + dataset[position].getField("5")

            holder.view.setOnClickListener{
                val intent = Intent(activity, ShowStudentActivity::class.java)

                intent.putExtra(STUDENTS, dataset)
                intent.putExtra(STUDENT, dataset[position])

                activity.startActivityForResult(intent, ShowStudentActivity.GET_INFO)
            }
        }

        override fun getItemCount() = dataset.size
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data != null){
            val intent = Intent()

            intent.putExtra(STUDENTS, data.getSerializableExtra(ShowStudentActivity.STUDENTS) as ArrayList<Student>)

            setResult(GET_INFO, intent)
            finish()
        }
    }
}


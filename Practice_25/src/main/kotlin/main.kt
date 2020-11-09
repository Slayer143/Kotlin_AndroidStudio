val scan = java.util.Scanner(System.`in`)

fun main() {
    println("Input number of students to input")
    val num = scan.nextLine().toInt()
    val students = Array(num) {Student("", "", List(0){0}) }

    for(n in 0 until num) {
        println("Input last name")
        val lName = scan.nextLine()

        println("Input name")
        val name = scan.nextLine()

        println("Input marks")
        val marks = scan.nextLine().split((" ")).map(String::toInt)

        students[n] = Student(lName, name, marks)
    }

    students.sortedBy { it.name }.sortedBy { it.lastName }.sortedByDescending { it.averageMark }

        if(students[0].averageMark == students[1].averageMark
            && students[1].averageMark == students[2].averageMark)
            students.forEachIndexed { index, student -> if(index < 3) println("Name: ${student.lastName} ${student.name} Mark: ${student.averageMark}") }
        else if(students[0].averageMark == students[1].averageMark
            && students[2].averageMark != students[1].averageMark)
            students.forEachIndexed { index, student -> if(index < 2) println("Name: ${student.lastName} ${student.name} Mark: ${student.averageMark}")
            else if(student.averageMark == students[0].averageMark) println("Name: ${student.lastName} ${student.name} Mark: ${student.averageMark}") }
    /*{ _, student -> if(student.averageMark > 2 ) {
            println("Name: ${student.lastName} ${student.name} Mark: ${student.averageMark}")
        } }*/
}

class Student(
    val lastName: String,
    val name: String,
    marks: List<Int>){
    val averageMark: Int = if(marks.isNotEmpty()) marks
        .reduce { start, next -> ((start + next)) }
        .toInt() / marks.size else 0
}
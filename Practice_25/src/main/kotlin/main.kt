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
        .forEachIndexed { index, student -> if(index < 4) println("Name: ${student.lastName} ${student.name} Mark: ${student.averageMark}") }

    /*val l = listOf("One", "Two", "Three")
    val l1 = listOf("oName", "tName", "thName")
    val l2 = listOf(1,2,3)
    val l3 = l2.zip(l1.zip(l))
    println(l3.sortedBy { it.second.first }.sortedBy { it.second.second }.sortedByDescending { it.first })*/
}

class Student(
    val lastName: String,
    val name: String,
    private val marks: List<Int>){
    val averageMark: Int = if(marks.isNotEmpty()) marks
        .reduce { start, next -> ((start + next)) }
        .toInt() / marks.size else 0
}
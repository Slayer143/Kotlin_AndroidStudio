import java.io.File

class DataOperator {
    private var file = File(" ")

    fun checkIfExists(): Boolean{
        file = File(scan.nextLine())

        return file.exists()
    }

    fun createFile(): Boolean{
        return file.createNewFile()
    }

    fun addStudent(){
        var name: String
        var lastName: String
        var secondName: String
        var gender: String
        var age: String

        do{
            println("Enter name")
            name = if(scan.hasNextLine()) scan.nextLine() else ""

            println("Enter last name")
            lastName = if(scan.hasNextLine()) scan.nextLine() else ""

            println("Enter second name")
            secondName = if(scan.hasNextLine()) scan.nextLine() else ""

            println("Enter gender")
            gender = if(scan.hasNextLine()) scan.nextLine() else ""

            println("Enter age")
            age = if(scan.hasNextLine()) scan.nextLine() else ""

            println("End of input...")
        }while (name == "" || lastName == "" || secondName == "" || gender == "" || age == "" || age.toIntOrNull() == null && scan.hasNextLine())

        val newStudent = Student(name, lastName, secondName, gender[0], age.toInt())

        file.writeText(file.readText() + newStudent.toFileWriteFormat() + "\n")
    }

    fun changeStudentInfo(){
        val students = convertToStudentsMutableList()

        println("Please input last name, name and second name of student you want to change info about\n")

        val infoForDeletion = if(scan.hasNextLine()) scan.nextLine()
            .split(" ")
            .toTypedArray()
        else Array(0){""}

        if(students.find { it.getField("1") == infoForDeletion[0]
                    && it.getField("2") == infoForDeletion[1]
                    && it.getField("3") == infoForDeletion[2] } != null
            && !infoForDeletion.contentEquals(Array(0){""}) && infoForDeletion.isNotEmpty()){
            println("Please enter new information. If input is empty information will not be changed")

            var name = ""
            var lastName = ""
            var secondName = ""
            var gender = ""
            var age = ""

            do {
                println("Name: ")
                name = if(scan.hasNextLine()) scan.nextLine() else ""

                println("Last name: ")
                lastName = if(scan.hasNextLine()) scan.nextLine() else ""

                println("Second name: ")
                secondName = if(scan.hasNextLine()) scan.nextLine() else ""

                println("Gender: ")
                gender = if(scan.hasNextLine()) scan.nextLine() else ""

                println("Age: ")
                age = if(scan.hasNextLine()) scan.nextLine() else ""
            }while(scan.hasNextLine())

            students.find { it.getField("1") == infoForDeletion[0]
                    && it.getField("2") == infoForDeletion[1]
                    && it.getField("3") == infoForDeletion[2] }?.changeStudentInfo( name, lastName, secondName, gender[0], age)

            var input = ""
            students.forEach { input += it.toFileWriteFormat() }

            if(input != "kotlin.Unit") file.writeText(input)
            else file.writeText("")
        }
        else println("Student with entered data was not found")
    }

    fun deleteStudent(){
        val students = convertToStudentsMutableList()

        println("Please input last name, name and second name of student you want to delete\n")

        val infoForDeletion = if(scan.hasNextLine()) scan.nextLine()
            .split(" ")
            .toTypedArray()
        else Array(0){""}

        if(!infoForDeletion.contentEquals(Array(0){""}) && infoForDeletion.isNotEmpty()
            && students.find {
                it.getField("1") == infoForDeletion[0]
                        && it.getField("2") == infoForDeletion[1]
                        && it.getField("3") == infoForDeletion[2] } != null ){
            if(students.remove(students.find {
                    it.getField("1") == infoForDeletion[0]
                            && it.getField("2") == infoForDeletion[1]
                            && it.getField("3") == infoForDeletion[2]
                })){
                var input = ""
                students.forEach { input +=  it.toFileWriteFormat() }

                if(input != "kotlin.Unit") file.writeText(input)
                else file.writeText("")
            }
            else println("Deletion error")
        }
        else println("Student with entered data was not found")
    }

    fun sortStudents(){
        val students =  convertToStudentsMutableList()

        println("Please select field of sorting:\n" +
                "1 - Last name\n" +
                "2 - Name\n" +
                "3 - Second name\n" +
                "4 - Gender\n" +
                "5 - Age\n" +
                "If you enter other value list will be sorted by students` last names\n")

        val field = if(scan.hasNextLine()) scan.nextLine() else "1"

        students.sortBy { it.getField(field)}

        students.forEach { it.writeOutStudent() }
    }

    fun searchStudent(){
        val students =  convertToStudentsMutableList()

        println("Please select field of search:\n" +
                "1 - Last name\n" +
                "2 - Name\n" +
                "3 - Second name\n" +
                "4 - Gender\n" +
                "5 - Age\n" +
                "If you enter other value list will be searched by students` last names\n")
        val field = if(scan.hasNextLine()) scan.nextLine() else "1"

        println("Input value to search")
        val value = if(scan.hasNextLine()) scan.nextLine() else " "

        val search = students.find { it.getField(field) == value }
        if(search != null) search.writeOutStudent() else println("There is no student with entered info")
    }

    fun showData(){
        val students = convertToStudentsMutableList()

        students.forEach { it.writeOutStudent()}
    }

    private fun convertToStudentsMutableList(): MutableList<Student>{
        val students = mutableListOf<Student>()

        val nonFormattedStudents = file.readLines()

        if(nonFormattedStudents.isNotEmpty() && !nonFormattedStudents.contains("kotlin.Unit"))
        for (it in file.readLines()) {
            it.split(" ").map { it2 -> students
                .add(Student(
                    if(it2.indices.contains(0)) it2.split(';')[0] else " ",
                    if(it2.indices.contains(1)) it2.split(';')[1] else " ",
                    if(it2.indices.contains(2)) it2.split(';')[2] else " ",
                    if(it2.indices.contains(3)) it2.split(';')[3].toCharArray()[0] else ' ',
                    if(it2.indices.contains(4)) it2.split(';')[4].toInt() else 0)) }
        }

        return students
    }
}
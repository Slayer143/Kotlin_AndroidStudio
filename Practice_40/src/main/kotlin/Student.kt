class Student(
    private var name: String,
    private var lastName: String,
    private var secondName: String,
    private var gender: Char,
    private var age: Int){
    fun changeStudentInfo(
        newName: String,
        newLastName: String,
        newSecondName: String,
        newGender: Char,
        newAge: String){
        if(newName != " ")
            name = newName

        if(newLastName != " ")
            lastName = newLastName

        if(newSecondName != " ")
            secondName = newSecondName

        if(newGender != ' ')
            gender = newGender

        if(newAge.toIntOrNull() != null){
            if(newAge.toInt() != 0
                && newAge.toInt() < 30
                && newAge.toInt() > 15)
                age = newAge.toInt()
        }
    }

    fun toFileWriteFormat(): String{
        return "${this.name};${this.lastName};${this.secondName};${this.gender};${this.age}"
    }

    fun writeOutStudent(){
        println("Last name: ${this.lastName} \n" +
                "Name: ${this.name} \n" +
                "Second name: ${this.secondName} \n" +
                "Gender: ${this.gender} \n" +
                "Age: ${this.age} \n")
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
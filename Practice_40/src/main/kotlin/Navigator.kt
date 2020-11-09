class Navigator{
    private val operator: DataOperator = DataOperator()

    fun showDatabaseChoice(){
        do {
            println(
                "1 - Select database from existing\n" +
                        "2 - Create new database\n" +
                        "3 - Exit\n"
            )

            val choice = if(scan.hasNextLine()) scan.nextLine() else " "

            databaseNavigate(choice)
        } while(choice != "3" && (scan.hasNextLine()))
    }

    private fun databaseNavigate(position: String){
        when(position){
            "1" -> {
                println("Please enter full name of file (with path)\n")
                if(operator.checkIfExists())
                    showActionWithDatabaseChoice()
                else{
                    println("Error")
                    //showDatabaseChoice()
                }
            }
            "2" -> {
                println("Please enter full name of file (with path)\n")
                if(!operator.checkIfExists()){
                    if(operator.createFile())
                    showActionWithDatabaseChoice()
                    else{
                        println("Error")
                      //  showDatabaseChoice()
                    }
                }
                else{
                    println("Error")
                    //showDatabaseChoice()
                }
            }
            "3" -> { println("Exit chosen... \n") }
            /*else -> { showDatabaseChoice() }*/
        }
    }

    private fun showActionWithDatabaseChoice(){
        do {
            println(
                "1 - Add student\n" +
                        "2 - Change student information\n" +
                        "3 - Delete student information\n" +
                        "4 - Sort students\n" +
                        "5 - Find student\n" +
                        "6 - Show all data\n" +
                        "7 - Exit"
            )

            val choice = if (scan.hasNextLine()) scan.nextLine() else " "

            actionNavigate(choice)
        } while( choice != "7" && (scan.hasNextLine()))
    }

    private fun actionNavigate(position: String){
        when(position){
            "1" -> {
                println("Adding chosen...\n")
                operator.addStudent()
                //showActionWithDatabaseChoice()
            }
            "2" -> {
                println("Changing chosen...\n")
                operator.changeStudentInfo()
                //showActionWithDatabaseChoice()
            }
            "3" -> {
                println("Deletion chosen...\n")
                operator.deleteStudent()
                //showActionWithDatabaseChoice()
            }
            "4" -> {
                println("Sorting chosen...\n")
                operator.sortStudents()
                //showActionWithDatabaseChoice()
            }
            "5" -> {
                println("Search chosen...\n")
                operator.searchStudent()
                //showActionWithDatabaseChoice()
            }
            "6" -> {
                println("All data here...\n")
                operator.showData()
                //showActionWithDatabaseChoice()
            }
            "7" -> { println("Exit chosen...\n") }
            //else -> { //showActionWithDatabaseChoice()
                // }
        }
    }
}
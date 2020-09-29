val scan = java.util.Scanner(System.`in`)

fun main(args: Array<String>) {
    println(TaskFour(if(scan.hasNext()) scan.nextLine() else "").doLogic())
}

class TaskFour(private val input: String){
    fun doLogic():Int{
        return input.split(" ").
    }
}
val scan = java.util.Scanner(System.`in`)

fun main() {
    println(TaskFour(if(scan.hasNext()) scan.nextLine() else "").doLogic())
}

class TaskFour(private val input: String){
    fun doLogic():String{
        return input.split(" ")
            .map { it[it.length - 2] }
            .reduce { start, next -> ((start.toInt() and next.toInt()).toChar()) }
            .toString()
    }
}
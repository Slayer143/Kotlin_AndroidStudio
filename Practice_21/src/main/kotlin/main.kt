val scan = java.util.Scanner(System.`in`)
fun main() {
    /*println(TaskOneRemastered(if(scan.hasNext()) scan.nextLine() else "").doLogic())

    println(TaskTwoRemastered(if(scan.hasNext()) scan.nextLine() else "").doLogic())
*/
    println(TaskThreeRemastered(if(scan.hasNext()) scan.nextLine() else "").doLogic())
}

class TaskOneRemastered(private val input: String){
    fun doLogic():String{
        return getEvenSum(
            0,
            input,
            0)
            .toString()
    }

    private tailrec fun getEvenSum(iteration:Int, input:String, sum:Int) {
        if (iteration == input.length
            && input[iteration].toInt() % 2 != 0)
            return getEvenSum(
                iteration + 1,
                input,
                sum + input[iteration].toInt() - '0'.toInt())
        else sum.toString()
    }
}

class TaskTwoRemastered(private val input: String){
    fun doLogic(): String {
        return input.split(" ").sortedBy { it }.toString()
    }
}

class TaskThreeRemastered(private val input: String){
    fun doLogic(): Char{
        return input.split(" ").filter { it.length % 2 != 0 }.maxByOrNull { it.length }.toString()[0]
    }
}


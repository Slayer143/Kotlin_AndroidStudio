import java.util.function.BooleanSupplier

val scan = java.util.Scanner(System.`in`)
fun main() {
    val input = if(scan.hasNext()) scan.nextLine() else ""

    println(doLogic(input))
}

fun doLogic(input:String):String{
    if(checkInputForNegative(input)){
        if(checkInputForNumbers(input)){

            return getEvenSum(0, input, 0)
        }

        return "Number is negative"
    }

    return "No numbers in input"
}

fun checkInputForNegative(input:String) : Boolean = input.toIntOrNull() != null

fun checkInputForNumbers(input:String) : Boolean = input.toInt() > 0

tailrec fun getEvenSum(iteration:Int, input:String, sum:Int, compare:(Int) -> Boolean = { input -> input % 2 == 0 }):String{
    var tempSum = 0

    if (iteration != input.length){
        if(compare(input[iteration].toInt())){
            tempSum = input[iteration].toInt() - '0'.toInt()
        }

        return getEvenSum(iteration + 1, input, sum + tempSum)
    }

    return sum.toString()
}
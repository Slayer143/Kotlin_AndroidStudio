val scan = java.util.Scanner(System.`in`)
fun main(args: Array<String>) {
    val input = scan.nextLine()

    println(doLogic(input))
}

fun doLogic(input:String):String{
    if(input.toIntOrNull() != null){
        if(input.toInt() > 0){

            return getEvenSumm(0, input, 0)
        }

            return "Number is negative"
    }

        return "No numbers in input"
}

tailrec fun getEvenSumm(iteration:Int, input:String, sum:Int):String{
    var tempSum = 0

    if (iteration != input.length){
        if(input[iteration].toInt() % 2 == 0){
            tempSum = input[iteration].toInt() - '0'.toInt()
        }

        return getEvenSumm(iteration + 1, input, sum + tempSum)
    }

    return sum.toString()
}
val scan = java.util.Scanner(System.`in`)
fun main(args: Array<String>) {
    val input = scan.nextLine()

    if(input.toIntOrNull() != null){
        println(input.toIntOrNull())

        if(input.toInt() > 0){
            var sum = 0

            for(char in input){
                println(char.toInt() - '0'.toInt())

                if(char.toInt() % 2 == 0)
                    sum += char.toInt() - '0'.toInt()
            }

            println(sum)
        }
        else
        println("Number is negative")
    }
    else
    println("No numbers in input")
}
val scan = java.util.Scanner(System.`in`)
var err = 0
var i = 0

fun main(args: Array<String>) {
    val arr = Array(3) {""}

    while(i < arr.size){
        val input = scan.nextLine()

        if(input.substringBefore(':').toIntOrNull() != null){
            if(input.substringBefore(':').toInt() >= 1
                && input.substringBefore(':').toInt() <= arr.size){
                if(arr[input.first().toInt() - '0'.toInt() - 1] == ""){
                    arr[input.first().toInt() - '0'.toInt() - 1] = input.substringAfter(':')

                    i++
                }
                else{
                    i = arr.size
                    err = 11
                    println("Program stopped with exception:"
                            + "\n"
                            + "WRONG_INDEX_EX_${err}")
                }

            }
            else{
                i = arr.size
                err = 12
                println("Program stopped with exception:"
                        + "\n"
                        + "WRONG_INDEX_EX_${err}")
            }

        }
        else{
            i = arr.size
            err = 21
            println("Program stopped with exception:"
                    + "\n"
                    + "INCORRECT_INPUT_FORMAT_EX_${err}")
        }

    }

    if(err == 0){
        for(i in arr.indices){
            println("Index: ${i + 1} value: ${arr[i]}")
        }
    }
}
val scan = java.util.Scanner(System.`in`)
var err = 0
var i = 0

//WRONG_INDEX_EX_11 - ИНДЕКС ВНЕ ГРАНИЦ МАССИВА
//WRONG_INDEX_EX_12 - ПО ЭТОМУ ИНДЕКСУ УЖЕ ЗАПИСАНО ЗНАЧЕНИЕ
//INCORRECT_INPUT_FORMAT_EX_21 - ИНДЕКС НЕ ЯВЛЯЕТСЯ ЧИСЛОМ

fun main() {
    val arr = Array(3) { "" }

    while (i < arr.size) {
        val input = if (scan.hasNext()) scan.nextLine() else " "
        var index = ""
        var value = ""
        var isDoubleDotDetected = false

        for(letter in input){
            if(letter == ':'){
                isDoubleDotDetected = true
            }
            if(!isDoubleDotDetected){
                index += letter
            }
            if(isDoubleDotDetected){
                value += letter
            }
        }

        if (index.toIntOrNull() != null) {
            if (index.toInt() >= 1 && index.toInt() <= arr.size) {
                if (arr[index.toInt() - 1] == "") {
                    arr[index.toInt() - 1] = value
                    i++
                } else {
                    i = arr.size
                    err = 12
                    println(
                        "Program stopped with exception:"
                                + "\n"
                                + "WRONG_INDEX_EX_${err}"
                    )
                }
            } else {
                i = arr.size
                err = 11
                println(
                    "Program stopped with exception:"
                            + "\n"
                            + "WRONG_INDEX_EX_${err}"
                )
            }
        } else {
            i = arr.size
            err = 21
            println(
                "Program stopped with exception:"
                        + "\n"
                        + "INCORRECT_INPUT_FORMAT_EX_${err}"
            )
        }
    }

    if (err == 0) {
        for (i in arr.indices) {
            println("Index: ${i + 1} value: ${arr[i]}")
        }
    }
}
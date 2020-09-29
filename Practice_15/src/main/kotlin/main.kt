val scan = java.util.Scanner(System.`in`)
const val arrSize = 3
//WRONG_INDEX_EX_11 - ИНДЕКС ВНЕ ГРАНИЦ МАССИВА
//WRONG_INDEX_EX_12 - ПО ЭТОМУ ИНДЕКСУ УЖЕ ЗАПИСАНО ЗНАЧЕНИЕ
//INCORRECT_INPUT_FORMAT_EX_21 - ИНДЕКС НЕ ЯВЛЯЕТСЯ ЧИСЛОМ

fun main() {
    var i = 0
    var arr = Array(arrSize) { "" }

    while (i < arrSize) {
        val input = if (scan.hasNext()) scan.nextLine() else " "

        arr[i] = input
        i++
    }

    val res = doLogic(*arr)

    if(res != null){
        for(i in res.indices){
            println("Index: ${i + 1} value: ${res[i]}")
        }
    }
}

//inputData - это набор введенных строк
fun doLogic(vararg inputData : String): Array<String>? {
    val arr = Array(arrSize) { "" }

    for(i in inputData){
        var index = ""
        var value = ""
        var isDoubleDotDetected = false

        for(letter in i){
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
                } else null
            } else null
        } else null
    }

    return arr
}

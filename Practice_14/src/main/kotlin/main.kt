val scan = java.util.Scanner(System.`in`)

fun main() {
    val input = if(scan.hasNext()) scan.nextLine() else ""

    val resultChar = doLogic(input)

    if(resultChar != ' '){
        println("First letter in the searched word is: $resultChar")
    }
    else println("No words with odd amount of letters detected")
}

fun doLogic(
    input:String,
    lengthCondition:(Int, Int) -> Boolean = { last:Int, now:Int -> last < now },
    amountOfLettersCondition:(Int) -> Boolean = {now:Int -> now % 2 != 0})
        :Char{
    var previousChar = ' '
    var checkChar = ' '
    var lastLen = 0
    var nowLen = 0
    var isFirst = true

    for(letter in input){
        if(letter != ' '){
            if(nowLen == 0)
                checkChar = letter

            nowLen++
        }
        if(letter == ' ' || letter == input[input.length - 1]){
            if(amountOfLettersCondition(nowLen)){
                if(lengthCondition(lastLen, nowLen) || isFirst){
                    lastLen = nowLen
                    previousChar = checkChar
                    nowLen = 0
                    isFirst = false
                }
            }
            else nowLen = 0
        }
    }

    return  previousChar
}
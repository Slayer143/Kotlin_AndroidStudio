val scan = java.util.Scanner(System.`in`)

fun main() {
    val input = if(scan.hasNext()) scan.nextLine() else ""
    var resultChar = ' '
    var checkChar = ' '
    var lastLen = 0
    var nowLen = 0

    for(letter in input){
        if(letter != ' '){
            if(nowLen == 0)
                checkChar = letter

            nowLen++
        }
        if(letter == ' ' || letter == input[input.length - 1]){
            if(nowLen % 2 != 0){
                if(lastLen < nowLen){
                    lastLen = nowLen
                    resultChar = checkChar
                    nowLen = 0
                }
            }
        }
    }

    if(resultChar != null || resultChar != ' '){
        println("First letter in the longest word with odd amount of letters is: $resultChar")
    }
    else println("No words with odd amount of letters detected")
}
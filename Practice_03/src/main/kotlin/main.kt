val scan = java.util.Scanner(System.`in`)

fun main(args: Array<String>) {
    val input = scan.nextLine()
    var word = ""
    var resultChar = ' '
    var len = 0

    for(letter in input){
        if(letter != ' '){
            word += letter
        }
        if(letter == ' ' || letter == input[input.length - 1]){
            if(word.length % 2 != 0){
                if(len < word.length){
                    len = word.length
                    resultChar = word[0]
                }
            }

            word = ""
        }
    }

    println("First letter in the longest word with odd amount of letters is: $resultChar")
}
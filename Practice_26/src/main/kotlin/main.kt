val scan = java.util.Scanner(System.`in`)

fun main() {
    println(if(scan.hasNext()) findFibonacci(scan.nextInt()) else println("No input"))
}

fun findFibonacci(n: Int): Int{
    return if(n == 1 || n == 2)
        1
    else
        findFibonacci(n - 1) + findFibonacci(n - 2)
}
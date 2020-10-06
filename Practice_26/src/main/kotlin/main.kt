import java.math.*
import kotlin.math.pow
import kotlin.math.sqrt

val scan = java.util.Scanner(System.`in`)

// Fn ~ pow(fi,n)/sqrt(5)

fun main() {
    println(findFibonacci(scan.nextInt().toDouble()))
}

fun findFibonacci(n: Double): Double{
    return 1.618.pow(n) / sqrt(5.0)
}
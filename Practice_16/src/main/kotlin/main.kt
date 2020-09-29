val scan = java.util.Scanner(System.`in`)

fun main(args: Array<String>) {
    val res = sum(::one, ::two)

    println(res)
}

fun one(a:Int):Int{
    return 5 * a
}

fun two(b:Int):Int{
    return 3 * b
}

fun sum(fc: (Int) -> Int = { a:Int -> a + 1 }, vararg funcs: (Int) -> Int): (Int) -> Int {


    return { a: Int ->
        var res = fc(a)

        for(i in funcs){
            res += i(a)
        }
        res
    }
}
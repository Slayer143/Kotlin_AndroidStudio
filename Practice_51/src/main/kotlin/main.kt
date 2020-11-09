fun main() {
}

fun<T> sum(vararg x: (T) -> Int ): (T) -> Int = {
    x.map { it1 -> it1(it) }.maxOf { it }
}



fun main() {
    val myList = MyList<String>()

    myList.add("sd")
    myList.add("sdsafadsf")

    myList.print()

}

class MyList<T>{
    private val lst = emptyList<T>().toMutableList()

    fun add(elem: T): Boolean{
        return lst.add(elem)
    }

    fun delete(): Boolean{
        return lst.removeAt(0) != null
    }

    fun print(){
        println(lst[0])
    }

    fun eraseAll(){
        lst.forEach { lst.remove(it) }
    }
}
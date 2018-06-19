package i_start


fun main(args: Array<String>) {


    val someList = "Strings are nice ranges".toList()


    val oneToTen = 1..10
    oneToTen.forEach {
        print(it)
    }
    println()
    for (c in 'a'..'z') {
        print(c)
    }
    println()
    for (i in oneToTen) {
        print(i)
    }
    println()
    //no more off by on (refactor)
    for (i in 0..someList.size - 1) {
        print(someList[i])
    }
}
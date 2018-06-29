package i_start


fun main(args: Array<String>) {


    val someList = "Strings are nice ranges".toList()


    val oneToTen = 1..10
    oneToTen.forEach {
        print(it)
    }
    println()
    val charRange = 'a'..'z'
    for (c in charRange) {
        print(c)
    }
    println()
    for (i in oneToTen) {
        print(i)
    }
    println()
    //no more off by on (refactor)
    for (i in 0 until someList.size) {
        print(someList[i])
    }
}
package i_start

import java.util.*


fun main(args: Array<String>) {
    val any: Any

    val bound = Random().nextInt(2)
    if (bound == 0) {
        any = Any()
    } else if (bound == 1) {
        any = 42
    } else if (bound == 2) {
        any = "Test string"
    } else {
        throw IllegalArgumentException("Should not happen")
    }
    //or ... refactor above statement, twice :-)

    if (any is String) {
        handleString(any)
    } else if (any is Int) {
        handleInt(any)
    } else {
        handleOther(any)
    }
    //or we can do this more "kotlin way" (refactor above statement)

}

fun handleString(anyString: String) {
    println("Is String ${anyString.toUpperCase()}")
}

fun handleInt(anyInt: Int) {
    println("Is Int: ${anyInt.rangeTo(20)}")
}

fun handleOther(nothingSpecial: Any) {
    println("Is something else ($nothingSpecial) .")
}
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

private fun handleOther(nothingSpecial: Any) {
    println("Is something else ($nothingSpecial) .")
}

private fun handleInt(any: Int) {
    println("Is Int: ${any.rangeTo(20)}")
}

private fun handleString(any: String) {
    println("Is String ${any.toUpperCase()}")
}
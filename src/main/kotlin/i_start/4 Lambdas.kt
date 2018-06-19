package i_start


fun String.higherOrderFunction(lambda: (String) -> Unit, times: Int):Unit {
    kotlin.repeat(times, { lambda(this) })
}

fun String.lambdaAsLastParameter(lambda: (String) -> Unit) {
    lambda(this)
}


fun main(args: Array<String>) {
    "Call labda as a para".higherOrderFunction({ string ->
        println(string)
    }, 3)


    "Name all the parameters, exec Once".lambdaAsLastParameter() { string ->
        repeat(1) { counter ->
            println(string)
        }
    }
    "It parameter".lambdaAsLastParameter() {
        repeat(2) { counter ->
            println(it)
        }
    }
    "Be careful with IT".lambdaAsLastParameter() {
        repeat(4) {
            println(it)
        }
    }
    "Do it with _".lambdaAsLastParameter() {
        repeat(5) { _ ->
            println(it)
        }
    }
}
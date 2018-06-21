package i_start


data class Point(val x: Int, val y: Int)

fun Point.metric(): Int = x * x + y * y

//operator
fun Point.compareTo(p: Point): Int {
    return this.metric().compareTo(p.metric())
}

fun String.lambdaAsLastParameter() {
    println(this.toUpperCase() + this.toLowerCase())

//    println(Point(2, 2) >= Point(1, 1))
}


fun main(args: Array<String>) {
    "Some concrete string".lambdaAsLastParameter()
}
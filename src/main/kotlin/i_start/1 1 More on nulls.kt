package i_start

fun main(args: Array<String>) {

    var nullableString: String? = null


    var length = nullableString?.length ?: 0


    println("First length is $length")

    nullableString = "test"

    length = nullableString?.length ?: 0

    println("Second length is $length")
}
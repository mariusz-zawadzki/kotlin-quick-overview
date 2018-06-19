package i_start


const val A_CONSTANT_VALUE = "A constant"
var aNormalVariable = 42.0


fun main(args: Array<String>) {
    var iNullable: Int?
    var i: Int = 1

    iNullable = i //not null to null
    iNullable = null
    //i = null // will not compile
    i = 2 //will work fine
    var `only local variables can be named like this` = 12

    println(A_CONSTANT_VALUE)
    println(aNormalVariable)
    aNormalVariable = 32.0
    println(aNormalVariable)
    println(`only local variables can be named like this`)
    `only local variables can be named like this` = 39
    println(`only local variables can be named like this`)
}


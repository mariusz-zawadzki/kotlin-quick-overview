package i_start

import java.math.BigDecimal


fun main(args: Array<String>) {

    //comprehensible compareTo
    val twelve = BigDecimal("12")
    val eleven = BigDecimal("11")
    println(twelve > eleven) // true
    println(twelve < eleven) // false


    //string operator override

    println("góra z górą?"-"?"-"gór") //-> a z ą
    println("góra z górą?"-("?"-"gór")) //-> góra z górą
    println(-"tset") // -> test
}

private operator fun String.unaryMinus() = this.reversed()

private operator fun String.minus(remove: String) = this.replace(remove,"")

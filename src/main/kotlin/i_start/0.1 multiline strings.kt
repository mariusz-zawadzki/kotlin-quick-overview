package i_start


fun main(args: Array<String>) {


    println("""
        This string is
        a multiple line string
        that is trimmed with indents
        It is a multiline string.
        """.trimIndent())

    println("""
        >This string is
        >a multiple line string
        >that is trimmed with indents
>It is a multiline string.
    """.trimMargin(marginPrefix = ">"))


}
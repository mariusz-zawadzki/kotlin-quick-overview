package i_start

import org.apache.commons.lang3.StringUtils

fun abbreviate(str:String, maxWidth:Int, abbrevMarker: String = "...", offset: Int = 0) : String{
    return StringUtils.abbreviate(str, abbrevMarker, offset, maxWidth)
}

val aVeryLongString = """
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget mauris sit amet orci maximus hendrerit quis non sapien. Etiam vel turpis tempus velit ultrices feugiat vitae vitae odio. Phasellus nec leo eu metus lacinia varius non sed leo. Proin volutpat magna at mi maximus, at tincidunt nibh cursus. Donec elementum pellentesque enim ut venenatis. Aliquam dapibus at nulla ac mattis. Vivamus condimentum turpis justo, at mattis quam eleifend eget. Donec eleifend enim non sodales varius. Suspendisse elementum sem sed pulvinar pretium. Quisque congue ante ut tellus mattis euismod. Fusce ultrices risus enim, eget finibus dui faucibus ac. Suspendisse ultrices sodales odio vitae hendrerit. Vestibulum elementum, diam eget tempus cursus, nunc sapien bibendum sem, nec vestibulum justo diam nec odio. Pellentesque gravida tempor mauris, nec pulvinar leo dignissim vitae. Aenean placerat sollicitudin ante.
    Morbi tristique tortor massa, sit amet lobortis risus faucibus vel. Cras interdum purus vel risus viverra suscipit eget at nulla. Aliquam ornare vestibulum lectus sit amet blandit. Nunc ut velit mauris. Sed efficitur tristique enim id pretium. Proin a sapien sed urna consequat fermentum sit amet vel nunc. Nullam ultrices augue eget magna fringilla scelerisque. Etiam nisl magna, dignissim a nibh in, euismod malesuada urna. Donec sagittis vel felis sed efficitur. Cras a bibendum nunc.
    Nam a placerat sapien. Sed id metus at metus bibendum hendrerit. Donec vel tempus orci, volutpat posuere est. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nunc aliquet mi fermentum, blandit odio lacinia, ultricies diam. Phasellus ut massa eros. Maecenas eu purus elit. Sed euismod magna a tellus pulvinar, quis consectetur orci finibus.
    Fusce pharetra dapibus est vel gravida. Vestibulum quam metus, laoreet ut sapien ac, hendrerit dapibus nisi. Fusce interdum ante magna, ac tempus ante gravida eget. Proin blandit ipsum magna, vel hendrerit lorem efficitur eget. Maecenas facilisis eleifend varius. Integer eget est pellentesque, semper ligula at, tristique arcu. Mauris mattis tempor mollis. Aenean dictum nulla risus, eget pretium mauris accumsan in. Donec eget mi sapien. Vestibulum vestibulum nec massa ac efficitur.
    Nunc id iaculis arcu, ac fringilla justo. Suspendisse dolor nisl, facilisis id ex vel, fringilla convallis lacus. Vivamus porttitor egestas nibh sit amet venenatis. Morbi vel feugiat sem, vel facilisis nisl. Donec sed libero et ante consectetur viverra. Vivamus quis leo non lacus condimentum faucibus. Ut dictum neque vel neque auctor, viverra lobortis ipsum mollis. Nulla ac nulla porttitor, egestas dolor id, tincidunt risus.
""".trimIndent()

fun main(args: Array<String>) {
    println(abbreviate(aVeryLongString, 30))
    println(abbreviate(aVeryLongString, 15))
    println(abbreviate(aVeryLongString, 15, "...", 5))
    println(abbreviate(aVeryLongString, 15, offset = 5))
    println(abbreviate(str = aVeryLongString, maxWidth = 15, offset = 5, abbrevMarker = "???"))
    println(abbreviate(str = aVeryLongString, maxWidth = 15, abbrevMarker = "???"))
}
package i_start


//wrapper by delegations
class SomeClass<T>(val delegate: List<T>) : List<T> by delegate {

    fun <R> map(transform: (T) -> R): SomeClass<R> {
        return SomeClass(delegate.map(transform))
    }
    // it can be either this up or as an extension function

    //we need toString because it is not a dataclass (it can be though)
    override fun toString(): String {
        return delegate.toString()
    }
}


//property delegation
class LazyPropertyUsingDelegates(initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}

fun main(args: Array<String>) {
    val someList: SomeClass<String> = SomeClass(listOf("apples", "bananas"))

    println(someList)

    val epplesAndBenenies: SomeClass<String> = someList.map { it.replace("a", "e") }

    println(epplesAndBenenies)

    val lazyPropertyUsingDelegates = LazyPropertyUsingDelegates {
        println("sideffect happens once")
        12
    }
    println("Before initalization")
    println(lazyPropertyUsingDelegates.lazyValue)
    println(lazyPropertyUsingDelegates.lazyValue)
}




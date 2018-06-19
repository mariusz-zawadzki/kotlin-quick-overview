package i_start



data class Customer(val id:Long, val users: List<User>)
data class User(val id: Long, val name:String, val email: Email)

typealias Email = String

val simple_email_regex = "[A-Za-z][A-Za-z\\-0-9.]*@[A-Za-z-0-9.]*[a-zA-Z]".toRegex()

private fun Email.isValid():Boolean {
    return this.matches(simple_email_regex)
}

fun main(args: Array<String>) {
    val someEmail = "Some@email.com"
    val customer1 = Customer(1L, listOf(User(10L, "SomeName", someEmail)))
    val customer2 = Customer(1L, listOf(User(10L, "SomeName", someEmail)))

    println("customer1.hashCode() == ${customer1.hashCode()}")
    println("customer2.hashCode() == ${customer2.hashCode()}")
    println("Are equal by == ${customer1 == customer2} because it calls customer.equals(customer2)")
    println("Are different by === ${customer1 === customer2} because it same as java customer == customer2")


    val customer3 = customer1.copy(id = 3L, users = listOf())
    val customer4 = customer1.copy(id = 4L, users = listOf())
    println(customer1)
    println(customer2)
    println(customer3)
    println(customer4)
}
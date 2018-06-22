package i_start


import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.*
//
//fun produceNumbers() = produce<Int> {
//    var x = 1 // start from 1
//    while (true) {
//        send(x++) // produce next
//        delay(100) // wait 0.1s
//    }
//}
//
//fun launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
//    channel.consumeEach {
//        println("Processor #$id received $it")
//    }
//}
//
//fun main(args: Array<String>) = runBlocking<Unit> {
//    val producer = produceNumbers()
//    repeat(5) { launchProcessor(it, producer) }
//    delay(950)
//    producer.cancel() // cancel producer coroutine and thus kill them all
//}


//
//suspend fun sendString(channel: SendChannel<String>, s: String, time: Long) {
//    while (true) {
//        delay(time)
//        channel.send(s)
//    }
//}
//
//fun main(args: Array<String>) = runBlocking<Unit> {
//    val channel = Channel<String>()
//    launch(coroutineContext) { sendString(channel, "foo", 200L) }
//    launch(coroutineContext) { sendString(channel, "BAR!", 400L) }
//    repeat(24) { // receive first six
//        println(channel.receive())
//    }
//    coroutineContext.cancelChildren() // cancel all children to let main finish
//}














//
//fun main(args: Array<String>) = runBlocking<Unit> {
//    val channel = Channel<Int>(6) // create buffered channel
//    val sender = launch(coroutineContext) { // launch sender coroutine
//        repeat(20) {
//            println("Sending $it") // print before sending each element
//            channel.send(it) // will suspend when buffer is full
//        }
//    }
//    // don't receive anything... just wait....
//    delay(1000)
//    channel.receive()
//    channel.receive()
//    delay(1000)
//    sender.cancel() // cancel sender coroutine
//}












//
//
//data class Ball(var hits: Int)
//
//fun main(args: Array<String>) = runBlocking<Unit> {
//    val table = Channel<Ball>() // a shared table
//    launch(coroutineContext) { player("ping", table) }
//    launch(coroutineContext) { player("pong", table) }
//    table.send(Ball(0)) // serve the ball
//    delay(1000) // delay 1 second
//    coroutineContext.cancelChildren() // game over, cancel them
//}
//
//suspend fun player(name: String, table: Channel<Ball>) {
//    for (ball in table) { // receive the ball in a loop
//        ball.hits++
//        println("$name $ball")
//        delay(300) // wait a bit
//        table.send(ball) // send the ball back
//    }
//}



















fun main(args: Array<String>) = runBlocking<Unit> {
    val tickerChannel1 = ticker(delay = 100, initialDelay = 0) // create ticker channel


    val start = System.currentTimeMillis()
    val table = Channel<Int>() // a shared table
    val sender = launch { // launch sender coroutine
        repeat(20) {
            println("Sending $it ${System.currentTimeMillis()-start}") // print before sending each element
            table.send(it) // will suspend when buffer is full
        }
    }
    val tickerChannel = tickerChannel1.zip(table).map { it.second }

    var nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
    println("Initial element is available immediately: $nextElement") // Initial delay hasn't passed yet

    nextElement = withTimeoutOrNull(50) { tickerChannel.receive() } // All subsequent elements has 100ms delay
    println("Next element is not ready in 50 ms: $nextElement")

    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready in 100 ms: $nextElement")

    // Emulate large consumption delays
    println("Consumer pauses for 150ms")
    delay(150)
    // Next element is available immediately
    nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
    println("Next element is available immediately after large consumer delay: $nextElement")
    // Note that the pause between `receive` calls is taken into account and next element arrives faster
    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready in 50ms after consumer pause in 150ms: $nextElement")

    sender.cancelAndJoin()
    table.cancel()
    tickerChannel.cancel() // indicate that no more elements are needed
}
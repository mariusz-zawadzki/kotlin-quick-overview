package i_start

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlin.coroutines.experimental.*
import kotlin.system.measureTimeMillis

val fibonacci = buildSequence {

    var a = 0
    var b = 1

    while (true) {
        yield(b)

        val next = a + b
        a = b; b = next
    }
}

private val THREADCOUNT = 100_000

fun main(args: Array<String>) {
    runBlocking<Unit> {
        val jobs = List(100_000) {
            // launch a lot of coroutines and list their jobs
            async {
                delay(1000L)
                val message = "."
                message
            }
        }
        jobs.map { it.await() }.forEach { print(it) }
        println()
    }

    println(fibonacci.take(10).joinToString())

}
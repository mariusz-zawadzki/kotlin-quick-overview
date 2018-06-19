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

private val THREADCOUNT = 100_000

fun main(args: Array<String>) {
    val cooRoutineC = AtomicInteger()
    val runBlockingC = AtomicInteger()
    val threadC = AtomicInteger()
    val runBlockingMeasure = measureTimeMillis {
        runBlocking<Unit> {
            val jobs = List(THREADCOUNT) {
                // launch a lot of coroutines and list their jobs
                async {
                    delay(100L, TimeUnit.MILLISECONDS)
                    1
                }
            }
            jobs.map { it.await() }.reduce(Int::plus).let { runBlockingC.addAndGet(it) }
        }
    }
    
    val threadsCreated = 1.rangeTo(THREADCOUNT).map {
        thread(start = false) {
            threadC.addAndGet(1)
        }
    }
    val coroutinesMeasure = measureTimeMillis {
        for (i in 1..THREADCOUNT) {
            launch {
                cooRoutineC.addAndGet(1)
            }
        }

    }

    val threadsMeasure = measureTimeMillis {
        threadsCreated.forEach { it.start() }
    }
    Thread.sleep(1000L)
    println("runBlocking: ${runBlockingC.get()} in ${runBlockingMeasure}ms")
    println("cooroutines: ${cooRoutineC.get()} in ${coroutinesMeasure}ms")
    println("threads    : ${threadC.get()} in ${threadsMeasure}ms")


}
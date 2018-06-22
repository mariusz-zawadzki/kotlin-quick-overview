package i_start

import kotlinx.coroutines.experimental.*


/**
 * coroutines examples:
 * https://github.com/Kotlin/kotlinx.coroutines/tree/master/core/kotlinx-coroutines-core/src/test/kotlin/guide
 */

//fun main(args: Array<String>) = runBlocking<Unit> {
//    repeat(1000) { i ->
//        delay(1L)
//        launch {
//            println("I'm sleeping $i ...")
//            delay(500L)
//        }
//    }
//    delay(2000L) // just quit after delay
//}

//fun main(args: Array<String>) = runBlocking<Unit> {
//    val job = launch {
//        repeat(1000) { i ->
//            println("I'm sleeping $i ...")
//            delay(500L)
//        }
//    }
//    delay(1300L) // delay a bit
//    println("main: I'm tired of waiting!")
//    job.cancel() // cancels the job
//    job.join() // waits for job's completion
//    println("main: Now I can quit.")
//}

//fun main(args: Array<String>) = runBlocking<Unit> {
//    val job = launch {
//        try {
//            repeat(1000) { i ->
//                println("I'm sleeping $i ...")
//                delay(500L)
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//
//        } finally {
//            println("I'm running finally")
//        }
//
//    }
//    delay(1300L) // delay a bit
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // cancels the job and waits for its completion
//    println("main: Now I can quit.")
//}
//
//fun main(args: Array<String>) = runBlocking<Unit> {
//    val job = launch {
//        try {
//            repeat(1000) { i ->
//                println("I'm sleeping $i ...")
//                delay(500L)
//            }
//        } finally {
//            withContext(NonCancellable) {
//                println("I'm running finally")
//                delay(1000L)
//                println("And I've just delayed for 1 sec because I'm non-cancellable")
//            }
//        }
//    }
//    delay(1300L) // delay a bit
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // cancels the job and waits for its completion
//    println("main: Now I can quit.")
//}


fun main(args: Array<String>) = runBlocking<Unit> {
    val result = withTimeout(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
        "Done" // will get cancelled before it produces this result
    }
    println("Result is $result")
}



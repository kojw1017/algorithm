import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

private val executor = Executors.newSingleThreadScheduledExecutor{
    Thread(it, "scheduler").apply {
        isDaemon = true
    }
}
suspend fun delay(time:Long) = suspendCoroutine {
    executor.schedule({
        it.resume(Unit)
    }, time, TimeUnit.NANOSECONDS)
}

var countinuation:Continuation<Unit>? = null
suspend fun suspendAndSetContinuation(){
    suspendCoroutine<Unit> {
        countinuation = it
    }
}

suspend fun main() {
    println("before")
//    suspendCoroutine<Unit> {
//        thread {
//            println("suspended")
//            Thread.sleep(1000)
//            it.resume(Unit)
//            println("resume")
//        }
//    }
    suspendAndSetContinuation()
    countinuation?.resume(Unit)
    println("after")
}
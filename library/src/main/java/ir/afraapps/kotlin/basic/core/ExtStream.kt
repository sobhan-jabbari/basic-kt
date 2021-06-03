package ir.afraapps.kotlin.basic.core

import java.io.*

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/16/19.
 */


fun Closeable.safeClose() {
    try {
        close()
    } catch (e: Exception) {
    }
}

fun Flushable.safeFlush() {
    try {
        flush()
    } catch (e: Exception) {
    }
}

fun OutputStream.safeFlushAndClose() {
    safeFlush()
    safeClose()
}




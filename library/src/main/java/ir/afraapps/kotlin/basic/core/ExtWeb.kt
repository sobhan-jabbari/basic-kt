package ir.afraapps.kotlin.basic.core

import java.io.*
import java.net.URLConnection
import java.nio.charset.Charset

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/16/19.
 */
fun URLConnection.writeData(data: String) {
    val os = outputStream
    val writer = BufferedWriter(OutputStreamWriter(os, Charset.forName("UTF-8")))
    writer.write(data)
    writer.safeFlush()
    writer.safeClose()
    os.safeClose()
}


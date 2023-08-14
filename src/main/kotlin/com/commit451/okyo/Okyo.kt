@file:Suppress("unused")

package com.commit451.okyo

import okio.buffer
import okio.sink
import okio.source
import java.io.*

@Suppress("NOTHING_TO_INLINE")
/**
 * okio made more ok, yo
 */
object Okyo {

    @JvmStatic
    @Throws(IOException::class)
    inline fun writeInputStreamToFile(inputStream: InputStream, file: File) {
        val sink = file.sink().buffer()
        val source = inputStream.source().buffer()
        sink.writeAll(source)
        sink.flush()
        sink.close()
        source.close()
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun writeByteArrayToFile(bytes: ByteArray, file: File) {
        val sink = file.sink().buffer()
        val source = ByteArrayInputStream(bytes).source().buffer()
        sink.writeAll(source)
        sink.flush()
        sink.close()
        source.close()
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun writeStringToOutputStream(string: String, outputStream: OutputStream) {
        return writeByteArrayToOutputStream(string.toByteArray(), outputStream)
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun writeByteArrayToOutputStream(bytes: ByteArray, outputStream: OutputStream) {
        val sink = outputStream.sink().buffer()
        val source = ByteArrayInputStream(bytes).source().buffer()
        sink.writeAll(source)
        sink.flush()
        sink.close()
        source.close()
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun writeStringToFile(content: String, file: File) {
        writeByteArrayToFile(content.toByteArray(), file)
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun writeFileToFile(fileToReadFrom: File, fileToWriteTo: File) {
        val sink = fileToWriteTo.sink().buffer()
        val source = fileToReadFrom.source().buffer()
        sink.writeAll(source)
        sink.flush()
        sink.close()
        source.close()
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun writeFileToOutputStream(fileToReadFrom: File, outputStream: OutputStream) {
        val sink = outputStream.sink().buffer()
        val source = fileToReadFrom.source().buffer()
        sink.writeAll(source)
        sink.flush()
        sink.close()
        source.close()
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun readInputStreamAsString(inputStream: InputStream): String {
        val source = inputStream.source().buffer()
        val content = source.readUtf8()
        source.close()
        return content
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun readFileAsString(file: File): String {
        val source = file.source().buffer()
        val content = source.readUtf8()
        source.close()
        return content
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun readFileAsByteArray(file: File): ByteArray {
        val source = file.source().buffer()
        val bytes = source.readByteArray()
        source.close()
        return bytes
    }
}

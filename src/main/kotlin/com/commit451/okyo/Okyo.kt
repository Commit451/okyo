package com.commit451.okyo

import java.io.ByteArrayInputStream
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

import okio.Okio

@Suppress("NOTHING_TO_INLINE")
/**
 * okio made more ok, yo
 */
object Okyo {

    @JvmStatic
    @Throws(IOException::class)
    inline fun writeInputStreamToFile(inputStream: InputStream, file: File) {
        val sink = Okio.buffer(Okio.sink(file))
        val source = Okio.buffer(Okio.source(inputStream))
        sink.writeAll(source)
        sink.flush()
        sink.close()
        source.close()
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun writeByteArrayToFile(bytes: ByteArray, file: File) {
        val sink = Okio.buffer(Okio.sink(file))
        val source = Okio.buffer(Okio.source(ByteArrayInputStream(bytes)))
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
        val sink = Okio.buffer(Okio.sink(outputStream))
        val source = Okio.buffer(Okio.source(ByteArrayInputStream(bytes)))
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
        val sink = Okio.buffer(Okio.sink(fileToWriteTo))
        val source = Okio.buffer(Okio.source(fileToReadFrom))
        sink.writeAll(source)
        sink.flush()
        sink.close()
        source.close()
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun readInputStreamAsString(inputStream: InputStream): String {
        val source = Okio.buffer(Okio.source(inputStream))
        val content = source.readUtf8()
        source.close()
        return content
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun readFileAsString(file: File): String {
        val source = Okio.buffer(Okio.source(file))
        val content = source.readUtf8()
        source.close()
        return content
    }

    @JvmStatic
    @Throws(IOException::class)
    inline fun readFileAsByteArray(file: File): ByteArray {
        val source = Okio.buffer(Okio.source(file))
        val bytes = source.readByteArray()
        source.close()
        return bytes
    }
}

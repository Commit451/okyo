package com.commit451.okyo;

import android.support.annotation.NonNull;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/**
 * okio made more ok, yo
 */
public class Okyo {

    public static void writeInputStreamToFile(@NonNull File file, @NonNull InputStream inputStream) throws IOException {
        BufferedSink sink = Okio.buffer(Okio.sink(file));
        BufferedSource source = Okio.buffer(Okio.source(inputStream));
        sink.writeAll(source);
        sink.flush();
        sink.close();
        source.close();
    }

    public static void writeByteArrayToFile(@NonNull File file, @NonNull byte[] bytes) throws IOException{
        BufferedSink sink = Okio.buffer(Okio.sink(file));
        BufferedSource source = Okio.buffer(Okio.source(new ByteArrayInputStream(bytes)));
        sink.writeAll(source);
        sink.flush();
        sink.close();
        source.close();
    }

    public static void writeStringToFile(@NonNull File file, @NonNull String content) throws IOException {
        writeByteArrayToFile(file, content.getBytes());
    }

    public static void writeFileToFile(@NonNull File fileToReadFrom, @NonNull File fileToWriteTo) throws IOException {
        BufferedSink sink = Okio.buffer(Okio.sink(fileToWriteTo));
        BufferedSource source = Okio.buffer(Okio.source(fileToReadFrom));
        sink.writeAll(source);
        sink.flush();
        sink.close();
        source.close();
    }

    @NonNull
    public static String readFileAsString(@NonNull File file) throws IOException {
        BufferedSource source = Okio.buffer(Okio.source(file));
        String content =  source.readUtf8();
        source.close();
        return content;
    }

    @NonNull
    public static byte[] readFileAsByteArray(@NonNull File file) throws IOException {
        BufferedSource source = Okio.buffer(Okio.source(file));
        byte[] bytes = source.readByteArray();
        source.close();
        return bytes;
    }
}

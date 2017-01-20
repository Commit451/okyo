package com.commit451.okyo;

import android.support.annotation.NonNull;

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

    @NonNull
    public static byte[] readByteArrayFromFile(@NonNull File file) throws IOException {
        BufferedSource fileSource = Okio.buffer(Okio.source(file));
        byte[] bytes = fileSource.readByteArray();
        fileSource.close();
        return bytes;
    }

    public static void writeInputStreamToFile(@NonNull File file, @NonNull InputStream inputStream) throws IOException {
        BufferedSink sink = Okio.buffer(Okio.sink(file));
        BufferedSource source = Okio.buffer(Okio.source(inputStream));
        sink.writeAll(source);
        sink.flush();
        sink.close();
        source.close();
    }
}

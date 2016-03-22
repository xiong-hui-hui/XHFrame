package com.xiong.tuan.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class IOUtils {

    private static final int BUFFER_SIZE = 4096;

    public static String toString(final InputStream is, final String charset) throws Exception {
        final char[] buffer = new char[BUFFER_SIZE];
        final StringBuilder out = new StringBuilder();
        try {
            Reader in = new InputStreamReader(is, charset);
            for (;;) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
        } catch (Exception e) {
            throw e;
        }
        return out.toString();
    }

    public static String toString(final InputStream is) throws Exception {
        return toString(is, "UTF-8");
    }
}

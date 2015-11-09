package com.undsf.util;

import java.io.*;

/**
 * Created by Arathi on 2015/9/15.
 */
public class StringFileWriter extends OutputStreamWriter {
    public static final String DEFAULT_CHARSET = "UTF-8";

    private File file;

    public StringFileWriter(String path, String charsetName) throws IOException {
        super(new FileOutputStream(path), charsetName);
        file = new File(path);
    }

    public static void WriteAll(String path, String content) throws IOException {
        WriteAll(path, content, DEFAULT_CHARSET);
    }

    public static void WriteAll(String path, String content, String charset) throws IOException{
        StringFileWriter sfw = new StringFileWriter(path, charset);
        sfw.write(content);
        sfw.close();
    }
}

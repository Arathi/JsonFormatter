package com.undsf.util;

import java.io.*;

/**
 * Created by Arathi on 2015/9/19.
 */
public class StringFileReader extends InputStreamReader {
    public static final String DEFAULT_CHARSET = "UTF-8";

    private File file = null;

    public StringFileReader(String path) throws IOException{
        super(new FileInputStream(path));
        file = new File(path);
    }

    public StringFileReader(String path, String charsetName) throws IOException {
        super(new FileInputStream(path), charsetName);
        file = new File(path);
    }

    public boolean exists() {
        if (file == null) return false;
        return file.exists();
    }

    public String readAll() throws IOException {
        Long fileLength = file.length();
        char[] contentArray = new char[fileLength.intValue()];
        int readLength = read(contentArray, 0, contentArray.length);
        String content = new String(contentArray, 0, readLength);
        return content;
    }

    public static String ReadAll(String path) throws IOException{
        return ReadAll(path, DEFAULT_CHARSET);
    }

    public static String ReadAll(String path, String charset) throws IOException{
        StringFileReader sfr = new StringFileReader(path, charset);
        String content = sfr.readAll();
        sfr.close();
        return content;
    }
}

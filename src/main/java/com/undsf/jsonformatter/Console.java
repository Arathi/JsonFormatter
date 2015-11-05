package com.undsf.jsonformatter;

import com.undsf.util.StringFileReader;

import java.io.IOException;

/**
 * Created by Arathi on 2015/11/05.
 */
public class Console {
    public static void usage(){
        System.out.println("java -cp -jar json-formatter.jar sourceJSONfile [destJSONfile]");
    }

    public static void main(String[] args) {
        if (args.length<=0){
            usage();
            return;
        }
        String srcFileName = args[0];
        String destFileName = null;
        if (args.length>=2) {
            destFileName = args[1];
        }
        try {
            String fileContent = StringFileReader.ReadAll(srcFileName);
            int index = fileContent.indexOf('{');
            String jsonContent = (index>0) ? fileContent.substring(index) : fileContent;
            //System.out.println("格式化前：\n" + jsonContent);
            String jsonFormatted = Formatter.format(jsonContent);
            System.out.println("格式化后：\n" + jsonFormatted);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

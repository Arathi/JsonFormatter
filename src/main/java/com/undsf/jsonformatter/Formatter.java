package com.undsf.jsonformatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Arathi on 2015/11/05.
 */
public class Formatter {
    public static Pattern SPACE_PATTERN = Pattern.compile("\\s+");

    public static String format(String json, int tab){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        String formattedJson = gson.toJson(jsonElement);
        if (tab != 2 && tab > 0){
            //修改每行前导空格数量
            String[] lines = formattedJson.split("\n");
            StringBuffer formatted4spacesJson = new StringBuffer();
            StringBuffer sb = new StringBuffer();
            for (String line : lines){
                Matcher matcher = SPACE_PATTERN.matcher(line);
                if (matcher.find()){
                    String spaces = matcher.group();
                    int length = spaces.length();
                    if (length % 2 == 0){
                        int spaceLevel = length / 2;
                        int spaceAmount = spaceLevel * tab;
                        for (int i = 0; i < spaceAmount; i++){
                            sb.append(' ');
                        }
                        sb.append( line.substring(length) );
                        line = sb.toString();
                        formatted4spacesJson.append(line);
                        formatted4spacesJson.append("\n");
                        sb.setLength(0);
                    }
                }
                else{
                    formatted4spacesJson.append(line);
                    formatted4spacesJson.append("\n");
                }
            }
            return formatted4spacesJson.toString();
        }
        return formattedJson;
    }

    public static String format(String json){
        return format(json, 4);
    }
}

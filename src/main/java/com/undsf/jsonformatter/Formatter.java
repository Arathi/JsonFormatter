package com.undsf.jsonformatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.HashMap;

/**
 * Created by Arathi on 2015/11/05.
 */
public class Formatter {
    public static String format(String json){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        String formattedJson = gson.toJson(jsonElement);
        return formattedJson;
    }
}

package com.example.mvp.utils;

import com.google.gson.Gson;

public class GsonUtil {
    public static Object gsonparsestr(String jsonstr,Class calzz){
        Gson gson = new Gson();
        return gson.fromJson(jsonstr,calzz);
    }
}

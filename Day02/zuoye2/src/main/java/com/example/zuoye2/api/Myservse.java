package com.example.zuoye2.api;


import com.example.zuoye2.bean.Bean;
import com.example.zuoye2.bean.Bean_Two;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Myservse {
//    public String url="https://api.apiopen.top/";
    public String url="http://v.juhe.cn/toutiao/";
//    @GET("getJoke?page=1&count=2&type=video")
//    Observable<Bean> geturl();

    @GET("index?key=315a54463602e8f87c8aa4b3a817bf84&type=top")
    Observable<Bean_Two> geturl();
}

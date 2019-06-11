package com.example.mvp.model;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RequestOpreate {
    public static void  getdata(String url, Observer observer){
        RequestManger.getRequestManger().getInterface().getData(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    //无参的post请求
    public static void postdata(String url,Observer observer){
        RequestManger.getRequestManger().getInterface().getData(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn((Scheduler) observer);
    }


    //没有参数，但是有post的请求头
    public static void postdata(String url, Map<String,Object> params,Observer observer){
        if (params==null)
            postdata(url,observer);
        else
            RequestManger.getRequestManger().getInterface().getData(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer);
    }
}

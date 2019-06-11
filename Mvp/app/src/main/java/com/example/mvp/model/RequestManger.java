package com.example.mvp.model;

import com.example.mvp.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RequestManger {
    public RequestManger() {
        initRetrofit();
    }

    private Retrofit retrofit;
    private void initRetrofit() {
         OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }
    private static RequestManger requestManger;

    public static RequestManger getRequestManger() {
        if (requestManger==null){
          synchronized (RequestManger.class){
              if (requestManger==null){
                  requestManger= new RequestManger();
              }
          }
        }
        return requestManger;
    }
    public RequestInterfase getInterface(){
        return retrofit.create(RequestInterfase.class);
    }
}

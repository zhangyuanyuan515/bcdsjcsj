package com.example.mvp.model;

import java.util.Map;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface RequestInterfase {
    @GET
    Observable<ResponseBody> getData(@Url String url);


    @GET
    @Streaming
    Observable<ResponseBody> downloadFile(@Url String url);


    @POST
    Observable<ResponseBody> postData(@Url String url);

    @POST
    Observable<ResponseBody> postData(@HeaderMap Map<String, Object> headers, @Url String url);


    @POST
    Observable<ResponseBody> postData(@Url String url, @FieldMap Map<String, Object> params);


    @POST
    Observable<ResponseBody> postData(@HeaderMap Map<String, Object> headerMap, @Url String url, @FieldMap Map<String, Object> params);

    @POST
    Observable<ResponseBody> postData(@HeaderMap Map<String, Object> headerMap, @Url String url, @Body RequestBody body);


    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @Part MultipartBody.Part part);
}

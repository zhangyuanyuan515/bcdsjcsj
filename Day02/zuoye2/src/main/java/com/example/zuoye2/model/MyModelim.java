package com.example.zuoye2.model;

import com.example.zuoye2.api.Myservse;
import com.example.zuoye2.bean.Bean;
import com.example.zuoye2.bean.Bean_Two;
import com.example.zuoye2.callback.Callbackk;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModelim implements MyModel{
    @Override
    public void getdata(final Callbackk callbackk) {
         Retrofit retrofit = new Retrofit.Builder().baseUrl(Myservse.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
         Myservse myservse = retrofit.create(Myservse.class);
        final Observable<Bean_Two> geturl = myservse.geturl();
        geturl.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean_Two>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean_Two bean) {
                        callbackk.OnSuccess(bean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        callbackk.OnFaile(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

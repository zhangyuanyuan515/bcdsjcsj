package com.example.mvp.presenter;

import com.example.mvp.Constants;
import com.example.mvp.base.Basepresenter;
import com.example.mvp.bean.Bean;
import com.example.mvp.model.RequestOpreate;
import com.example.mvp.utils.GsonUtil;
import com.example.mvp.view.frangment.HomeFragment;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class HomePresneter implements Basepresenter {
    private HomeFragment homeFragment;

    public HomePresneter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    @Override
    public void start() {
        homeFragment.showProgress();
        RequestOpreate.getdata(Constants.DATA, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody body) {
                try {
                    String string = body.string();
                    Object gsonparsestr = GsonUtil.gsonparsestr(string, Bean.class);
               if (gsonparsestr instanceof Bean){
                   Bean bean= (Bean) gsonparsestr;
                   homeFragment.OnSuccess(bean);
                   homeFragment.hideProgress();
               }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onError(Throwable e) {
                homeFragment.OnFaile(e.getMessage());
                homeFragment.hideProgress();

            }

            @Override
            public void onComplete() {

            }
        });
    }
}

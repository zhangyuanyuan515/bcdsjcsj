package com.example.day02.presenter;

import com.example.day02.bean.Bean;
import com.example.day02.bean.Bean_Two;
import com.example.day02.callback.Callbackk;
import com.example.day02.model.MyModel;
import com.example.day02.view.Myview;

public class Mypresenter implements Myprenser, Callbackk {
    private MyModel myModel;
    private Myview myview;

    public Mypresenter(MyModel myModel, Myview myview) {
        this.myModel = myModel;
        this.myview = myview;
    }

    @Override
    public void getdata() {
        myModel.getdata(this);

    }

    @Override
    public void OnSuccess(Bean_Two bean) {
        myview.OnSuccess(bean);
    }

    @Override
    public void OnFaile(String msg) {
        myview.OnFaile(msg);

    }
}

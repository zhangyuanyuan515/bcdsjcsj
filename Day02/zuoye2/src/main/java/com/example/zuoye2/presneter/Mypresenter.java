package com.example.zuoye2.presneter;

import com.example.zuoye2.bean.Bean;
import com.example.zuoye2.bean.Bean_Two;
import com.example.zuoye2.callback.Callbackk;
import com.example.zuoye2.model.MyModel;
import com.example.zuoye2.view.Myview;

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

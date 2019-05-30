package com.example.zuoye2.callback;


import com.example.zuoye2.bean.Bean;
import com.example.zuoye2.bean.Bean_Two;

public interface Callbackk {
    void OnSuccess(Bean_Two bean);
    void OnFaile(String msg);
}

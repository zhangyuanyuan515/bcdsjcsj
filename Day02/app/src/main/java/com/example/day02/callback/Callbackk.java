package com.example.day02.callback;

import com.example.day02.bean.Bean;
import com.example.day02.bean.Bean_Two;

public interface Callbackk {
    void OnSuccess(Bean_Two bean);
    void OnFaile(String msg);
}

package com.example.mvp.base;

public interface BaseView<T> {
    void showProgress();
    void hideProgress();
    void OnSuccess(T t);
    void OnFaile(String msg);
}

package com.example.mvp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFrangment extends Fragment {

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(getFrangmentLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initlistenner();
        initdata();
        return view;
    }

    protected abstract void initlistenner();

    protected abstract void initdata();

    protected abstract int getFrangmentLayoutId();
}

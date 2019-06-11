package com.example.mvp.view.frangment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.base.BaseFrangment;
import com.example.mvp.base.BaseView;
import com.example.mvp.bean.Bean;
import com.example.mvp.presenter.HomePresneter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFrangment implements BaseView {


    private static final String TAG = HomeFragment.class.getName();
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    Unbinder unbinder;
    private HomeFragment homeFragment;
    private HomePresneter homePresneter;

    @Override
    protected void initlistenner() {

    }

    @Override
    protected void initdata() {
        homePresneter = new HomePresneter(this);
        homePresneter.start();

    }

    @Override
    protected int getFrangmentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void showProgress() {
        progressbar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressbar.setVisibility(View.GONE);


    }

    @Override
    public void OnSuccess(Object o) {
        if (o instanceof Bean){
            Bean bean= (Bean) o;
            tv.setText(bean.toString());
        }

    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );

    }
}

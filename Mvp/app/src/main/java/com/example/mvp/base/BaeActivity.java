package com.example.mvp.base;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public abstract class BaeActivity extends AppCompatActivity {
    protected ArrayList<Activity> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(getLayoutId());
        arrayList.add(this);
        init();
        super.onCreate(savedInstanceState);
    }

    protected abstract int getLayoutId();


    protected abstract void init();
    //返回键

    @Override
    public void onBackPressed() {
        if (arrayList!=null&&arrayList.size()>0){
            for (Activity activity:arrayList) {
                activity.finish();
            }
        }
        super.onBackPressed();
    }
}

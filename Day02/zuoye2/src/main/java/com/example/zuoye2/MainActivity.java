package com.example.zuoye2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.zuoye2.adapter.RecviewAdapter;
import com.example.zuoye2.bean.Bean;
import com.example.zuoye2.bean.Bean_Two;
import com.example.zuoye2.model.MyModelim;
import com.example.zuoye2.presneter.Mypresenter;
import com.example.zuoye2.view.Myview;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Myview {

    private static final String TAG = MainActivity.class.getName();
    private RecyclerView mRe;
    private Mypresenter mypresenter;
    private  ArrayList<Bean_Two.ResultBean.DataBean> list = new ArrayList<>();
    private RecviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initdata();
    }

    private void initdata() {
        mypresenter = new Mypresenter(new MyModelim(), this);
        mypresenter.getdata();
    }

    private void initView() {
        mRe = (RecyclerView) findViewById(R.id.re);
        mRe.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecviewAdapter(this, list);
        mRe.setAdapter(adapter);
        adapter.setClick(new RecviewAdapter.onclick() {
            @Override
            public void onclick(View view, int i) {
                 Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                 startActivity(intent);
                 finish();
            }
        });
    }

    @Override
    public void OnSuccess(Bean_Two bean) {
         ArrayList<Bean_Two.ResultBean.DataBean> data = bean.getResult().getData();
        list.addAll(data);
         adapter.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );

    }
}

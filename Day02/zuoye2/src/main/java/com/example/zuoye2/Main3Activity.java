package com.example.zuoye2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zuoye2.adapter.RecviewAdapter_Three;
import com.example.zuoye2.adapter.RecviewAdapter_Two;
import com.example.zuoye2.bean.Bean_Three;
import com.example.zuoye2.bean.Bean_Two;
import com.example.zuoye2.model.MyModelim;
import com.example.zuoye2.presneter.Mypresenter;
import com.example.zuoye2.view.Myview;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private RecyclerView mRe;
    private Mypresenter mypresenter;
    private ArrayList<Bean_Three> list = new ArrayList<>();
    private RecviewAdapter_Three three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initquery();
    }

    private void initquery() {
         List<Bean_Three> query = DbHolder.getDbHolder().query();
        list.addAll(query);
        three.notifyDataSetChanged();
    }

    private void initView() {
        mRe = (RecyclerView) findViewById(R.id.re);
        mRe.setLayoutManager(new LinearLayoutManager(this));
        three = new RecviewAdapter_Three(this,list);
        mRe.setAdapter(three);
        three.setClick(new RecviewAdapter_Two.onclick() {
            @Override
            public void onclick(View view, Bean_Two.ResultBean.DataBean bean) {


            }
        });
    }
}

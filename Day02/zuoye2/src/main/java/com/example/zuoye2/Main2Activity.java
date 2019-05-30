package com.example.zuoye2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.zuoye2.adapter.RecviewAdapter_Two;
import com.example.zuoye2.bean.Bean_Three;
import com.example.zuoye2.bean.Bean_Two;
import com.example.zuoye2.model.MyModelim;
import com.example.zuoye2.presneter.Mypresenter;
import com.example.zuoye2.view.Myview;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements Myview {

    private RecyclerView mRe;
    private Mypresenter mypresenter;
    private  ArrayList<Bean_Two.ResultBean.DataBean> list = new ArrayList<>();
    private RecviewAdapter_Two adapterTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        iitdata();
    }

    private void iitdata() {
        mypresenter = new Mypresenter(new MyModelim(), this);
        mypresenter.getdata();
    }

    private void initView() {
        mRe = (RecyclerView) findViewById(R.id.re);
        mRe.setLayoutManager(new LinearLayoutManager(this));
        adapterTwo = new RecviewAdapter_Two(this, list);
        mRe.setAdapter(adapterTwo);

        adapterTwo.setItem(new RecviewAdapter_Two.onitemm() {
            @Override
            public void onitemm(View view, int i) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
                finish();
            }
        });





        adapterTwo.setClick(new RecviewAdapter_Two.onclick() {
            @Override
            public void onclick(final View view, final Bean_Two.ResultBean.DataBean bean) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setTitle("是否添加");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CheckBox ch = view.findViewById(R.id.ch);
                        if (ch.isChecked()) {
                            Bean_Three three = new Bean_Three();
                            three.setAuthor_name(bean.getAuthor_name());
                            three.setCategory(bean.getCategory());
                            three.setThumbnail_pic_s02(bean.getThumbnail_pic_s02());
                            DbHolder.getDbHolder().insert(three);
                            Toast.makeText(Main2Activity.this, "添加成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                final AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }



    @Override
    public void OnSuccess(Bean_Two bean) {
        ArrayList<Bean_Two.ResultBean.DataBean> data = bean.getResult().getData();
        list.addAll(data);
        adapterTwo.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {

    }
}



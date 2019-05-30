package com.example.day02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    private WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mWeb = (WebView) findViewById(R.id.web);
         String header = getIntent().getStringExtra("url");
         mWeb.loadUrl(header);
    }
}

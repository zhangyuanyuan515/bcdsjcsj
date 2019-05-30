package com.example.day02;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.day02.adapter.FrngVp;
import com.example.day02.frangment.GuanZhuFragment;
import com.example.day02.frangment.SchoolFragment;
import com.example.day02.frangment.ShuJuKuFragment;
import com.example.day02.frangment.WebFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> list;
    private FrngVp frngVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        list = new ArrayList<>();
        list.add(new SchoolFragment());
        list.add(new GuanZhuFragment());


        frngVp = new FrngVp(getSupportFragmentManager(), list);
        mVp.setAdapter(frngVp);

        mTab.addTab(mTab.newTab().setText("校门"));
        mTab.addTab(mTab.newTab().setText("关注"));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
    }
}

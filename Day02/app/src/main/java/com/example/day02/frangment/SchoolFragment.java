package com.example.day02.frangment;
//张媛媛   1809A

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day02.Main2Activity;
import com.example.day02.R;
import com.example.day02.adapter.RecviewAdapter;
import com.example.day02.bean.Bean;
import com.example.day02.bean.Bean_Two;
import com.example.day02.model.MyModelim;
import com.example.day02.presenter.Mypresenter;
import com.example.day02.view.Myview;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolFragment extends Fragment implements Myview {


    private static final String TAG = SchoolFragment.class.getName();
    private View view;
    private RecyclerView mRe;
    private Mypresenter mypresenter;
    ArrayList<Bean_Two.ResultBean.DataBean> list=new ArrayList<>();
    private RecviewAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_school, container, false);
        initView(inflate);
        initdata();
        return inflate;
    }

    private void initdata() {
        mypresenter = new Mypresenter(new MyModelim(), this);
        mypresenter.getdata();
    }

    private void initView(View inflate) {
        mRe = (RecyclerView) inflate.findViewById(R.id.re);
        mRe.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new RecviewAdapter(getContext(), list);
        mRe.setAdapter(adapter);
        adapter.setClick(new RecviewAdapter.onclick() {
            @Override
            public void onclick(View view, int i) {
                String url = list.get(i).getUrl();
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }

    @Override
    public void OnSuccess(Bean_Two bean) {
         ArrayList<Bean_Two.ResultBean.DataBean> data = bean.getResult().getData();
//        Log.d(TAG, "OnSuccess: "+result.size());
         list.addAll(data);
         adapter.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );

    }
}

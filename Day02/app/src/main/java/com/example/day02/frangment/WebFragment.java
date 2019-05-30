package com.example.day02.frangment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.day02.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebFragment extends Fragment {


    private View view;
    private WebView mWb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_web, container, false);
        initView(inflate);

        return inflate;

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            EventBus.getDefault().register(this);
        }
    }

    private void initView(View inflate) {
        mWb = (WebView) inflate.findViewById(R.id.wb);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getdata(String msg){
        if (msg!=null){
            mWb.setWebViewClient(new WebViewClient());
            mWb.loadUrl(msg);
        }
         String stickyEvent = EventBus.getDefault().getStickyEvent(String.class);
        if ( stickyEvent!=null){
           EventBus.getDefault().removeStickyEvent(stickyEvent);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

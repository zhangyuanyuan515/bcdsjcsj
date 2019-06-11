package com.example.mvp.view.activity;
import com.example.mvp.R;
import com.example.mvp.base.BaeActivity;
import com.example.mvp.view.frangment.HomeFragment;

public class HomeActivity extends BaeActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bae;
    }

    @Override
    protected void init() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rl,new HomeFragment(),
                        HomeFragment.class.getSimpleName())
                .commitAllowingStateLoss();

    }
}

package com.example.lifecycle;

import com.example.lifecycle.activities.FirstActivity;
import com.example.lifecycle.base.BaseActivity;
import com.example.lifecycle.databinding.ActivityMainBinding;
import com.example.lifecycle.serivces.GodEye;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        dataBinding.begin.setOnClickListener(v -> {
            setTargetActivity(FirstActivity.class);
            selectLaunchMode();
        });
        GodEye.start(this, null, GodEye.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GodEye.stop(this, GodEye.class);
    }
}

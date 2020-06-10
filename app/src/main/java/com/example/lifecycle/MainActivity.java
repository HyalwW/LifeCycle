package com.example.lifecycle;

import android.app.AlertDialog;
import android.content.Intent;
import android.provider.Settings;

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
        if (!Settings.canDrawOverlays(this)) {
            try {
                AlertDialog alertDialog = new AlertDialog.Builder(this)
                        .setTitle("权限")
                        .setMessage("请先打开悬浮窗权限！")
                        .setPositiveButton("设置", (dialog, which) -> {
                            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                            startActivity(intent);
                            dialog.dismiss();
                        })
                        .create();
                alertDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        dataBinding.begin.setOnClickListener(v -> {
            setTargetActivity(FirstActivity.class);
            selectLaunchMode();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!Utils.isServiceRunning(this, GodEye.class)) {
            GodEye.start(this, null, GodEye.class);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GodEye.stop(this, GodEye.class);
    }
}

package com.example.lifecycle.serivces;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.lifecycle.R;
import com.example.lifecycle.Utils;
import com.example.lifecycle.base.BaseFloatService;
import com.example.lifecycle.databinding.FloatTestBinding;

public class TestFloatService extends BaseFloatService<FloatTestBinding> {
    @Override
    protected int layoutId() {
        return R.layout.float_test;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        triggerMove(dataBinding.base);
        dataBinding.stop.setOnClickListener(v -> stopSelf());
    }

    @Override
    protected int getAnimId() {
        return 0;
    }

    @Override
    protected int showX() {
        return 0;
    }

    @Override
    protected int showY() {
        return 200;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        send("onCreate");
        show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        send("onStartCommand");
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        send("onBind");
        return new Serve();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        send("onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        send("onRebind");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        send("onDestroy");
    }

    private void send(String info) {
        Utils.sendLifeCycleInfo(info, TAG, 0);
    }

    private class Serve extends Binder {

    }
}

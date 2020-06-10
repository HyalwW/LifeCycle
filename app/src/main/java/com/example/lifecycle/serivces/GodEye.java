package com.example.lifecycle.serivces;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;

import com.example.lifecycle.R;
import com.example.lifecycle.Utils;
import com.example.lifecycle.base.BaseFloatService;
import com.example.lifecycle.databinding.LayoutFloatGodBinding;

import java.util.ArrayList;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/10
 * Description: blablabla
 */
public class GodEye extends BaseFloatService<LayoutFloatGodBinding> {
    private GodAdapter adapter;
    private LifeCycleReceiver receiver;

    @Override
    protected int layoutId() {
        return R.layout.layout_float_god;
    }

    @Override
    protected void initData() {
        triggerMove(dataBinding.base);
        receiver = new LifeCycleReceiver(this);
        receiver.register();
        adapter = new GodAdapter(this, new ArrayList<>());
    }

    @Override
    protected void initView() {
        dataBinding.listView.setAdapter(adapter);
        dataBinding.clear.setOnClickListener(v -> adapter.clear());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        receiver.unRegister();
    }

    @Override
    protected int getAnimId() {
        return 0;
    }

    @Override
    protected int showX() {
        return 10;
    }

    @Override
    protected int showY() {
        return 100;
    }

    private class LifeCycleReceiver extends BroadcastReceiver {
        private Context target;

        public LifeCycleReceiver(Context target) {
            this.target = target;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if (Utils.LIFE_CYCLE_ACTION.equals(intent.getAction())) {
                String info = intent.getStringExtra("info");
                String tag = intent.getStringExtra("tag");
                int color = intent.getIntExtra("color", Color.TRANSPARENT);
                adapter.addItem(new Bean(info, tag, color));
                dataBinding.listView.smoothScrollToPosition(adapter.getCount());
            }
        }

        public void register() {
            IntentFilter filter = new IntentFilter(Utils.LIFE_CYCLE_ACTION);
            target.registerReceiver(this, filter);
        }

        public void unRegister() {
            target.unregisterReceiver(this);
        }
    }
}

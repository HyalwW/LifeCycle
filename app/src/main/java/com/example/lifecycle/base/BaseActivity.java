package com.example.lifecycle.base;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.lifecycle.LaunchDialog;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/10
 * Description: blablabla
 */
public abstract class BaseActivity<DB extends ViewDataBinding> extends AppCompatActivity {
    protected String TAG = getClass().getSimpleName();
    protected DB dataBinding;
    private Class<? extends BaseActivity> targetActivity;
    protected int launchMode = -1;
    private LaunchDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, layoutId());
        dialog = new LaunchDialog(this);
        dialog.setListener(mode -> {
            launchMode = mode;
            startToTarget();
            dialog.dismiss();
        });
        initView();
    }


    protected void setTargetActivity(Class<? extends BaseActivity> target) {
        targetActivity = target;
    }

    protected void selectLaunchMode() {
        dialog.show();
    }

    protected void startToTarget() {
        if (launchMode != -1 || targetActivity != null) {
            Intent intent = new Intent(this, targetActivity);
            if (launchMode > 0) {
                intent.addFlags(launchMode());
            }
            launchMode = -1;
            targetActivity = null;
            startActivity(intent);
        }
    }

    private int launchMode() {
        switch (launchMode) {
            case 1:
                Log.e("wwh", "BaseActivity --> launchMode: singleTask");
                return Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP;
            case 2:
                Log.e("wwh", "BaseActivity --> launchMode: singleTop");
                return Intent.FLAG_ACTIVITY_SINGLE_TOP;
            case 3:
                Log.e("wwh", "BaseActivity --> launchMode: singleInstance");
                return Intent.FLAG_ACTIVITY_NEW_TASK;
        }
        throw new IllegalStateException("wrong mode");
    }

    protected abstract int layoutId();

    protected abstract void initView();
}

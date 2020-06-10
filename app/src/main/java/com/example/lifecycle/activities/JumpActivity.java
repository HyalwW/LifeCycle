package com.example.lifecycle.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.lifecycle.FragJumpDialog;
import com.example.lifecycle.R;
import com.example.lifecycle.Utils;
import com.example.lifecycle.base.BaseActivity;
import com.example.lifecycle.databinding.ActivityJumpBinding;
import com.example.lifecycle.fragments.AFragment;
import com.example.lifecycle.fragments.BFragment;
import com.example.lifecycle.fragments.JumpFragment;

import java.util.Random;

public abstract class JumpActivity extends BaseActivity<ActivityJumpBinding> implements View.OnClickListener {
    private int color;
    private FragJumpDialog dialog;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private JumpFragment toFragment;

    @Override
    protected int layoutId() {
        return R.layout.activity_jump;
    }

    @Override
    protected void initView() {
        dataBinding.jumpA.setOnClickListener(this);
        dataBinding.jumpA.setTag(FirstActivity.class);
        dataBinding.jumpB.setOnClickListener(this);
        dataBinding.jumpB.setTag(SecondActivity.class);
        dataBinding.jumpC.setOnClickListener(this);
        dataBinding.jumpC.setTag(ThirdActivity.class);
        dataBinding.tag.setText(TAG);
        Random random = new Random();
        color = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        dataBinding.base.setBackgroundColor(color);
        dialog = new FragJumpDialog(this);
        fragmentManager = getSupportFragmentManager();
        dialog.setListener(type -> {
            if (toFragment == null) {
                return;
            }
            transaction = fragmentManager.beginTransaction();
            switch (type) {
                case 1:
                    transaction.add(R.id.fragment_container, toFragment).commit();
                    break;
                case 2:
                    transaction.replace(R.id.fragment_container, toFragment).commit();
                    break;
            }
            toFragment = null;
        });
        dataBinding.aFragment.setOnClickListener(v -> {
            toFragment = new AFragment();
            dialog.show();
        });
        dataBinding.bFragment.setOnClickListener(v -> {
            toFragment = new BFragment();
            dialog.show();
        });
        dataBinding.hideShow.setOnClickListener(v -> {
            int size = fragmentManager.getFragments().size();
            transaction = fragmentManager.beginTransaction();
            if (size > 0) {
                Fragment fragment = fragmentManager.getFragments().get(size - 1);
                if (fragment.isHidden()) {
                    transaction.show(fragment).commit();
                } else {
                    transaction.hide(fragment).commit();
                }
            }
        });
        dataBinding.remove.setOnClickListener(v -> {
            int size = fragmentManager.getFragments().size();
            transaction = fragmentManager.beginTransaction();
            if (size > 0) {
                Fragment fragment = fragmentManager.getFragments().get(size - 1);
                transaction.remove(fragment).commit();
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        send("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        send("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        send("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        send("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        send("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        send("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        send("onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        send("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        send("onRestoreInstanceState");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        send("onAttachedToWindow");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        send("onDetachedFromWindow");
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        send("onWindowFocusChanged");
//    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        send("onNewIntent");
    }

    private void send(String info) {
        Utils.sendLifeCycleInfo(info, TAG, color);
    }

    @Override
    public void onClick(View v) {
        setTargetActivity((Class<? extends BaseActivity>) v.getTag());
        selectLaunchMode();
    }
}

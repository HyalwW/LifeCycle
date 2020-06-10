package com.example.lifecycle.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lifecycle.R;
import com.example.lifecycle.Utils;
import com.example.lifecycle.base.BaseFragment;
import com.example.lifecycle.databinding.FragmentJumpBinding;

import java.util.Random;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/10
 * Description: blablabla
 */
public class JumpFragment extends BaseFragment<FragmentJumpBinding> {
    private int color;

    @Override
    protected int layoutId() {
        return R.layout.fragment_jump;
    }

    @Override
    protected void initView() {
        dataBinding.tag.setText(TAG);
        dataBinding.base.setBackgroundColor(color);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        send("onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        send("onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        send("onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        send("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        send("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        send("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        send("onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        send("onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        send("onDestroy");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        send("onConfigurationChanged");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Random random = new Random();
        color = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        super.onAttach(context);
        send("onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        send("onDetach");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        send("onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        send("onViewStateRestored");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        send("onHiddenChanged");
    }


    private void send(String info) {
        Utils.sendLifeCycleInfo(info, TAG, color);
    }
}

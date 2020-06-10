package com.example.lifecycle.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/10
 * Description: blablabla
 */
public abstract class BaseAlertDialog<DB extends ViewDataBinding> extends AlertDialog {
    protected DB dataBinding;

    protected BaseAlertDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), layoutId(), null, false);
        setContentView(dataBinding.getRoot());
        initView();
    }

    protected abstract int layoutId();

    protected abstract void initView();
}

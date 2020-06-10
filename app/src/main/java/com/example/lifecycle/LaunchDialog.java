package com.example.lifecycle;

import android.content.Context;
import android.view.View;

import com.example.lifecycle.base.BaseAlertDialog;
import com.example.lifecycle.databinding.DialogSelectLaunchModeBinding;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/10
 * Description: blablabla
 */
public class LaunchDialog extends BaseAlertDialog<DialogSelectLaunchModeBinding> implements View.OnClickListener {

    public LaunchDialog(Context context) {
        super(context);
    }

    public void setListener(OnLaunchModeChoose listener) {
        this.listener = listener;
    }

    @Override
    protected int layoutId() {
        return R.layout.dialog_select_launch_mode;
    }

    @Override
    protected void initView() {
        dataBinding.standard.setTag(0);
        dataBinding.standard.setOnClickListener(this);
        dataBinding.singleTask.setTag(1);
        dataBinding.singleTask.setOnClickListener(this);
        dataBinding.singleTop.setTag(2);
        dataBinding.singleTop.setOnClickListener(this);
        dataBinding.singleInstance.setTag(3);
        dataBinding.singleInstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onChoose((Integer) v.getTag());
        }
    }

    private OnLaunchModeChoose listener;

    public interface OnLaunchModeChoose {
        void onChoose(int mode);
    }
}

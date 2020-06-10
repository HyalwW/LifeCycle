package com.example.lifecycle;

import android.content.Context;
import android.view.View;

import com.example.lifecycle.base.BaseAlertDialog;
import com.example.lifecycle.databinding.DialogFragJumpBinding;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/10
 * Description: blablabla
 */
public class FragJumpDialog extends BaseAlertDialog<DialogFragJumpBinding> implements View.OnClickListener {
    public FragJumpDialog(Context context) {
        super(context);
    }

    @Override
    protected int layoutId() {
        return R.layout.dialog_frag_jump;
    }

    @Override
    protected void initView() {
        dataBinding.add.setTag(1);
        dataBinding.add.setOnClickListener(this);
        dataBinding.replace.setTag(2);
        dataBinding.replace.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onTypeSelected((Integer) v.getTag());
        }
        dismiss();
    }

    public void setListener(OnJumpTypeListener listener) {
        this.listener = listener;
    }

    private OnJumpTypeListener listener;

    public interface OnJumpTypeListener {
        void onTypeSelected(int type);
    }
}

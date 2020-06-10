package com.example.lifecycle.serivces;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifecycle.R;
import com.example.lifecycle.base.AbsAdapter;
import com.example.lifecycle.databinding.ItemInfoBinding;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/10
 * Description: blablabla
 */
public class GodViewHolder extends AbsAdapter.BaseViewHolder<Bean, ItemInfoBinding> {
    public GodViewHolder(Context context, ViewGroup parent) {
        super(context, parent);
    }

    @Override
    protected int layoutId() {
        return R.layout.item_info;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void bind(Bean data, int position, int count) {
        dataBinding.base.setBackgroundColor(data.getColor());
        dataBinding.info.setText(String.format("%s:%s", data.getTag(), data.getInfo()));
        dataBinding.top.setVisibility(View.VISIBLE);
        dataBinding.bottom.setVisibility(View.VISIBLE);
        if (position == 0) {
            dataBinding.top.setVisibility(View.GONE);
        } else if (position == count - 1) {
            dataBinding.bottom.setVisibility(View.GONE);
        }
    }

}

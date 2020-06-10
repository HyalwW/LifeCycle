package com.example.lifecycle.serivces;

import android.content.Context;
import android.view.ViewGroup;

import com.example.lifecycle.base.AbsAdapter;

import java.util.List;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/10
 * Description: blablabla
 */
public class GodAdapter extends AbsAdapter<Bean, GodViewHolder> {
    public GodAdapter(Context mContext, List<Bean> list) {
        super(mContext, list);
    }

    @Override
    protected GodViewHolder viewHolder(ViewGroup parent) {
        return new GodViewHolder(mContext, parent);
    }
}

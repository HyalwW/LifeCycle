package com.example.lifecycle.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import java.util.List;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/10
 * Description: blablabla
 */
public abstract class AbsAdapter<T, VH extends AbsAdapter.BaseViewHolder> extends BaseAdapter {
    protected Context mContext;
    protected List<T> list;

    public AbsAdapter(Context mContext, List<T> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(T item) {
        list.add(item);
        notifyDataSetChanged();
    }

    public void remove(T item) {
        list.remove(item);
        notifyDataSetChanged();
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VH viewHolder;
        if (convertView == null) {
            viewHolder = viewHolder(parent);
            convertView = viewHolder.getView();
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (VH) convertView.getTag();
        }
        viewHolder.bind(getItem(position), position, getCount());
        return convertView;
    }

    protected abstract VH viewHolder(ViewGroup parent);


    public static abstract class BaseViewHolder<T, DB extends ViewDataBinding> {
        protected DB dataBinding;

        public BaseViewHolder(Context context, ViewGroup parent) {
            dataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId(), parent, false);
            initView();
        }

        public View getView() {
            return dataBinding.getRoot();
        }

        protected abstract int layoutId();

        protected abstract void initView();

        public abstract void bind(T data, int position, int count);
    }
}

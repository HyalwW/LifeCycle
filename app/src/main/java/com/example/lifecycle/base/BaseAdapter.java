//package com.example.lifecycle.base;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.databinding.DataBindingUtil;
//import androidx.databinding.ViewDataBinding;
//
//import java.util.List;
//
///**
// * Created by Wang.Wenhui
// * Date: 2020/6/10
// * Description: blablabla
// */
//public abstract class BaseAdapter<T, DB extends ViewDataBinding> extends android.widget.BaseAdapter {
//    protected Context mContext;
//    protected List<T> list;
//
//    public BaseAdapter(Context mContext, List<T> list) {
//        this.mContext = mContext;
//        this.list = list;
//    }
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public T getItem(int position) {
//        return list.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
//        if (convertView == null) {
//            viewHolder = new ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(mContext), itemLayoutId(), parent, false));
//            convertView = viewHolder.dataBinding.getRoot();
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//        viewHolder.bind(getItem(position), position, getCount());
//        return convertView;
//    }
//
//    private class ViewHolder {
//
//        private DB dataBinding;
//
//        public ViewHolder(DB dataBinding) {
//            this.dataBinding = dataBinding;
//            initItemView(dataBinding);
//        }
//
//        void bind(T item, int position, int count) {
//            bindItem(dataBinding, item, position, count);
//        }
//
//    }
//
//    protected abstract int itemLayoutId();
//
//    protected abstract void initItemView(DB dataBinding);
//
//    protected abstract void bindItem(DB dataBinding, T item, int position, int count);
//}

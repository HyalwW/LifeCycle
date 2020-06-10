package com.example.lifecycle;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.example.lifecycle.serivces.GodEye;

import java.util.ArrayList;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/10
 * Description: blablabla
 */
public class MyApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Utils.init(this);
    }

}

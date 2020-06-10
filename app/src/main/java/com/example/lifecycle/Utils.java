package com.example.lifecycle;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import java.util.ArrayList;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/10
 * Description: blablabla
 */
public class Utils {
    private static Application mContext;
    public static final String LIFE_CYCLE_ACTION = "lifeCycle_action";

    public static void init(Application application) {
        mContext = application;
    }

    public Context getContext() {
        return mContext;
    }

    public static void sendLifeCycleInfo(String info, String tag, int color) {
        Intent intent = new Intent(LIFE_CYCLE_ACTION);
        intent.putExtra("info", info);
        intent.putExtra("tag", tag);
        intent.putExtra("color", color);
        sendBroadcast(intent);
    }

    public static void sendBroadcast(Intent intent) {
        mContext.sendBroadcast(intent);
    }

    public static boolean isServiceRunning(Context context, Class service) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ArrayList<ActivityManager.RunningServiceInfo> runningServices = (ArrayList<ActivityManager.RunningServiceInfo>) manager.getRunningServices(100);
        for (ActivityManager.RunningServiceInfo serviceInfo : runningServices) {
            if (TextUtils.equals(serviceInfo.service.getClassName(), service.getName())) {
                return true;
            }
        }
        return false;
    }
}

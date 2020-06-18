package com.example.lifecycle;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/16
 * Description: blablabla
 */
public class TaskInfo {

    private String processName;
    private int totalPrivateDirty;

    public void setAppPackageName(String processName) {
        this.processName = processName;
    }

    public void setMemorySize(int totalPrivateDirty) {
        this.totalPrivateDirty = totalPrivateDirty;
    }
}

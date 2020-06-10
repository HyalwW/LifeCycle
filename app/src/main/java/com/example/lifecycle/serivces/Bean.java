package com.example.lifecycle.serivces;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/10
 * Description: blablabla
 */
public class Bean {
    private String info, tag;
    private int color;

    public Bean(String info, String tag, int color) {
        this.info = info;
        this.tag = tag;
        this.color = color;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

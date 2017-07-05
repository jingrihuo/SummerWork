package com.zucc.circle.summerwork;

import android.app.Application;

import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.RequestQueue;

/**
 * Created by 圆圈 on 2017-07-03.
 */

public class MyApplication extends Application {
    //请求队列
    private static RequestQueue mRequestQueue;
    public static RequestQueue getmRequestQueue(){
        return mRequestQueue;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        NoHttp.initialize(this); // NoHttp默认初始化。
        Logger.setDebug(true); // 开启NoHttp调试模式。
        Logger.setTag("NoHttpSample"); // 设置NoHttp打印Log的TAG。
        mRequestQueue = NoHttp.newRequestQueue();
    }
}
package com.example.weiliu.nfn;

import android.app.Application;
import android.content.Context;

import com.example.weiliu.nfn.bean.DaoMaster;
import com.example.weiliu.nfn.bean.DaoSession;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by wei.liu
 * on 2018/6/9.
 */

public class MyApplication extends Application {
    
    private static final String TAG = MyApplication.class.getSimpleName();

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();



    }



    public static Context getContext(){
        return mContext;
    }
}

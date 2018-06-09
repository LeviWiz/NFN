package com.example.weiliu.nfn;

import com.example.weiliu.nfn.bean.DaoMaster;
import com.example.weiliu.nfn.bean.DaoSession;

/**
 * Created by wei.liu
 * on 2018/6/9.
 */

public class DBHelper {

    public static DaoSession getSession() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getContext(), "nfn.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        return daoMaster.newSession();
    }
}
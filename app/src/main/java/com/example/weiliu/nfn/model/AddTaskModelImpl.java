package com.example.weiliu.nfn.model;

import android.util.Log;

import com.example.weiliu.nfn.DBHelper;
import com.example.weiliu.nfn.bean.DaoMaster;
import com.example.weiliu.nfn.bean.DaoSession;
import com.example.weiliu.nfn.bean.TaskBean;
import com.example.weiliu.nfn.event.AddRefreshEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by wei.liu
 * on 2018/5/29.
 */

public class AddTaskModelImpl implements AddTaskModel {
    private static final String TAG = AddTaskModelImpl.class.getSimpleName();

    @Override
    public boolean saveTaskBean(TaskBean taskBean) {
        DBHelper.getSession().getTaskBeanDao().insert(taskBean);
        EventBus.getDefault().post(new AddRefreshEvent(true));
        //插入数据成功,返回true
        return true;
    }
}

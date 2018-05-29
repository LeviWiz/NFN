package com.example.weiliu.nfn.model;

import android.util.Log;

import com.example.weiliu.nfn.bean.TaskBean;

/**
 * Created by wei.liu on 2018/5/29.
 */

public class AddTaskModelImpl implements AddTaskModel {
    private static final String TAG = AddTaskModelImpl.class.getSimpleName();

    @Override
    public boolean saveTaskBean(TaskBean taskBean) {
        Log.e(TAG, "taskBean.title==" + taskBean.getTitle());
        return false;
    }
}

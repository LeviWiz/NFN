package com.example.weiliu.nfn.model;

import android.util.Log;
import android.view.View;

import com.example.weiliu.nfn.DBHelper;
import com.example.weiliu.nfn.R;
import com.example.weiliu.nfn.bean.TaskBean;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wei.liu on 2018/5/28.
 *
 */

public class TaskModelImpl implements TaskModel {
    private static final String TAG = TaskModelImpl.class.getSimpleName();


    @Override
    public List getTaskList() {

        List<TaskBean> taskList= DBHelper.getSession().getTaskBeanDao().queryBuilder().build().list();
        return taskList;

    }
}

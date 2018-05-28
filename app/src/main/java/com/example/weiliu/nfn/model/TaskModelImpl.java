package com.example.weiliu.nfn.model;

import android.util.Log;

import com.example.weiliu.nfn.bean.TaskBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wei.liu on 2018/5/28.
 */

public class TaskModelImpl implements TaskModel {
    private static final String TAG = TaskModelImpl.class.getSimpleName();


    @Override
    public List getTaskList() {

        Log.e(TAG, "getTaskList: 11111");
        List taskList= new ArrayList<TaskBean>();

        taskList.add(new TaskBean("吃饭",1));
        taskList.add(new TaskBean("吃肉",2));
        taskList.add(new TaskBean("喝水",3));
        taskList.add(new TaskBean("上班",1));
        taskList.add(new TaskBean("看书",4));
        taskList.add(new TaskBean("走路",2));

        return taskList;

    }
}

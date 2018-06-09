package com.example.weiliu.nfn.presenter;

import android.content.Context;
import android.util.Log;

import com.example.weiliu.nfn.adapter.TaskAdapter;
import com.example.weiliu.nfn.model.TaskModel;
import com.example.weiliu.nfn.model.TaskModelImpl;
import com.example.weiliu.nfn.view.TaskView;

import java.util.List;

/**
 * Created by wei.liu on 2018/5/28.
 * 我们可以看到P中的所有方法，都是通过V或M的接口来操作M或V。
 */

public class TaskPresenter {

    private static final String TAG = TaskPresenter.class.getSimpleName();
    private Context context;

    private TaskModel taskModel;
    private TaskView taskView;

    private List taskList = null;
    private TaskAdapter adapter = null;

    public TaskPresenter(Context context, TaskView taskView) {
        this.context = context;
        this.taskView = taskView;
        taskModel = new TaskModelImpl();
    }

    public List getTaskList() {
        Log.e(TAG, "loadTaskList: " );
        //我们可以看到P中的所有方法，都是通过V或M的接口来操作M或V。
        return taskModel.getTaskList();
    }

    public void showTaskList() {

        Log.e(TAG, "loadTaskList: " );
        //我们可以看到P中的所有方法，都是通过V或M的接口来操作M或V。
        taskList = taskModel.getTaskList();
        if (null != taskList && taskList.size() >0) {
            taskView.showTaskList(taskList);
        }
    }
}

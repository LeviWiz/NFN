package com.example.weiliu.nfn.presenter;

import android.content.Context;

import com.example.weiliu.nfn.model.AddTaskModel;
import com.example.weiliu.nfn.model.AddTaskModelImpl;
import com.example.weiliu.nfn.view.AddTaskView;

/**
 * Created by wei.liu on 2018/5/29.
 */

public class AddTaskPresenter {

    private AddTaskView addTaskView;
    private AddTaskModel addTaskModel;
    private Context context;

    public AddTaskPresenter(Context context, AddTaskView addTaskView) {
        this.context = context;
        this.addTaskView = addTaskView;
        this.addTaskModel = new AddTaskModelImpl();
    }

    public void saveTaskBean() {
        addTaskModel.saveTaskBean(addTaskView.getTask());
    }
}

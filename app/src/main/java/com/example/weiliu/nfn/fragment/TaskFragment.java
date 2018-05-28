package com.example.weiliu.nfn.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weiliu.nfn.R;
import com.example.weiliu.nfn.adapter.TaskAdapter;
import com.example.weiliu.nfn.bean.TaskBean;
import com.example.weiliu.nfn.presenter.TaskPresenter;
import com.example.weiliu.nfn.view.TaskView;

import java.util.ArrayList;
import java.util.List;

public class TaskFragment extends Fragment implements TaskView{

    private RecyclerView taskRecyclerView;
    private TaskPresenter taskPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        taskPresenter = new TaskPresenter(getContext(),TaskFragment.this);
        taskPresenter.loadTaskList();
        super.onViewCreated(view, savedInstanceState);
    }

    private void initView(View view) {
        taskRecyclerView = view.findViewById(R.id.rv_task);

    }

    @Override
    public void showTaskList(List list) {

        TaskAdapter adapter = new TaskAdapter(getContext(),list);

        taskRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        taskRecyclerView.setAdapter(adapter);
    }
}

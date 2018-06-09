package com.example.weiliu.nfn.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weiliu.nfn.R;
import com.example.weiliu.nfn.adapter.TaskAdapter;
import com.example.weiliu.nfn.event.AddRefreshEvent;
import com.example.weiliu.nfn.presenter.TaskPresenter;
import com.example.weiliu.nfn.view.TaskView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class TaskFragment extends Fragment implements TaskView {

    private static final String TAG = TaskFragment.class.getSimpleName();


    private RecyclerView taskRecyclerView;
    private TaskPresenter taskPresenter;
    private TaskAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        taskPresenter = new TaskPresenter(getContext(), TaskFragment.this);
        taskPresenter.showTaskList();
        super.onViewCreated(view, savedInstanceState);
    }

    private void initView(View view) {
        taskRecyclerView = view.findViewById(R.id.rv_task);

    }

    @Override
    public void showTaskList(List list) {
        adapter = new TaskAdapter(getContext());
        adapter.setTaskList(list);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        taskRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        taskRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onMessageReceived(AddRefreshEvent event){
        adapter.setTaskList(taskPresenter.getTaskList());
        adapter.notifyDataSetChanged();
    }
}

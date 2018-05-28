package com.example.weiliu.nfn.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weiliu.nfn.R;
import com.example.weiliu.nfn.bean.TaskBean;

import java.util.List;

/**
 * Created by wei.liu on 2018/5/28.
 *
 */

public class TaskAdapter extends RecyclerView.Adapter {

    private List<TaskBean> taskList;
    private Context context;

    public TaskAdapter(Context context, List taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TaskHolder(LayoutInflater.from(context).inflate(R.layout.layout_task_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TaskHolder) holder).title.setText(taskList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public TaskHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_task);
        }
    }
}

package com.example.weiliu.nfn.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wei.liu on 2018/5/28.
 */

public class TaskAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class TaskHolder extends RecyclerView.ViewHolder{

        private TextView title;

        public TaskHolder(View itemView) {
            super(itemView);
        }

    }
}

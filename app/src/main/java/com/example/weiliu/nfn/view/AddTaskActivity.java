package com.example.weiliu.nfn.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weiliu.nfn.MyApplication;
import com.example.weiliu.nfn.R;
import com.example.weiliu.nfn.bean.TaskBean;
import com.example.weiliu.nfn.presenter.AddTaskPresenter;

public class AddTaskActivity extends AppCompatActivity implements AddTaskView {

    private static final String TAG = AddTaskActivity.class.getSimpleName();

    private EditText etTitle;
    private EditText etPoint;

    private AddTaskPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        initView();
    }

    private void initView() {
        etTitle = findViewById(R.id.add_task_title);
        etPoint = findViewById(R.id.add_task_point);
        etPoint.setInputType(InputType.TYPE_CLASS_NUMBER);

        findViewById(R.id.add_task_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etTitle.getText())) {
                    Toast.makeText(MyApplication.getContext(), "请输入标题!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(etPoint.getText())) {
                    Toast.makeText(MyApplication.getContext(), "请输入点数!", Toast.LENGTH_SHORT).show();
                } else {
                    presenter = new AddTaskPresenter(AddTaskActivity.this,AddTaskActivity.this);
                    presenter.saveTaskBean();
                    finish();
                }
            }
        });
    }

    @Override
    public TaskBean getTask() {
        return new TaskBean(etTitle.getText().toString(), Integer.parseInt(etPoint.getText().toString()));
    }
}

package com.example.weiliu.nfn.bean;

/**
 * Created by wei.liu on 2018/5/28.
 * 第一版只有每日单次任务
 */
public class TaskBean {

    private String title;
    private int point;
    private boolean doneIt;

    public TaskBean(String title, int point) {
        this(title, point, false);
    }

    private TaskBean(String title, int point, boolean doneIt) {
        this.title = title;
        this.point = point;
        this.doneIt = doneIt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isDoneIt() {
        return doneIt;
    }

    public void setDoneIt(boolean doneIt) {
        this.doneIt = doneIt;
    }

    @Override
    public String toString() {
        return getTitle() + " " + getPoint() + " " + isDoneIt();
    }
}

package com.example.weiliu.nfn.bean;

/**
 * Created by wei.liu on 2018/5/28.
 * 第一版只有单次奖励
 */
public class RewardsBean {

    private String title;
    private int point;
    private boolean gotIt;

    public RewardsBean(String title, int point) {
        this(title, point, false);
    }

    private RewardsBean(String title, int point, boolean gotIt) {
        this.title = title;
        this.point = point;
        this.gotIt = gotIt;
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

    public boolean isGotIt() {
        return gotIt;
    }

    public void setGotIt(boolean gotIt) {
        this.gotIt = gotIt;
    }

    @Override
    public String toString() {
        return getTitle() + " " + getPoint() + " " + isGotIt();
    }
}

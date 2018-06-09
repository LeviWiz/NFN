package com.example.weiliu.nfn.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wei.liu on 2018/5/28.
 * 第一版只有单次任务
 */
@Entity
public class TaskBean {
    @Id
    private Long id;
    @Property(nameInDb = "TITLE")
    private String title;
    @Property(nameInDb = "POINT")
    private int point;
    @Property(nameInDb = "DONEIT")
    private boolean doneIt;

    public TaskBean(String title, int point) {
        this(null,title, point, false);
    }

    @Generated(hash = 2067219959)
    public TaskBean(Long id, String title, int point, boolean doneIt) {
        this.id = id;
        this.title = title;
        this.point = point;
        this.doneIt = doneIt;
    }

    @Generated(hash = 1443476586)
    public TaskBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean getDoneIt() {
        return this.doneIt;
    }

    public void setDoneIt(boolean doneIt) {
        this.doneIt = doneIt;
    }
    
}

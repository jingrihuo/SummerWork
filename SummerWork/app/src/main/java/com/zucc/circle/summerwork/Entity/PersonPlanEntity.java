package com.zucc.circle.summerwork.Entity;

/**
 * Created by 圆圈 on 2017-07-05.
 */

public class PersonPlanEntity {
    public String title;
    public String start_time;
    public String end_time;
    public String note;
    public PersonPlanEntity(String title, String start_time, String end_time) {
        this.title = title;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}

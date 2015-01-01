package com.ttpro.haha.example2;

/**
 * Created by haha on 1/1/2015.
 */
public class Work {
    private String work;
    private String time;
    private boolean checked;
    public Work() {
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Work(String work, String time) {
        this.work = work;
        this.time = time;
        checked = false;

    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

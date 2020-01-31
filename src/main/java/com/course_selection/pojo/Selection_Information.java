package com.course_selection.pojo;

public class Selection_Information {
    private int id;
    private int sid;
    private int eid;
    private String ename;
    private int weeknum;
    private String section;
    private int lab;
    private int seat;

    @Override
    public String toString() {
        return "Selection_Information{" +
                "id=" + id +
                ", sid=" + sid +
                ", eid=" + eid +
                ", ename='" + ename + '\'' +
                ", weeknum=" + weeknum +
                ", section='" + section + '\'' +
                ", lab=" + lab +
                ", seat=" + seat +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(int weeknum) {
        this.weeknum = weeknum;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getLab() {
        return lab;
    }

    public void setLab(int lab) {
        this.lab = lab;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}

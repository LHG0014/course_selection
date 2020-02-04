package com.course_selection.pojo;

import java.io.Serializable;

public class Experiment implements Serializable {
    private Integer id;
    private Integer eid;
    private String ename;
    private Integer one_start;
    private Integer one_end;
    private Integer two_start;
    private Integer two_end;
    private Integer lab;
    private Integer seat_num;
    private String remark;

    @Override
    public String toString() {
        return "ExperimentMapper{" +
                "id=" + id +
                ", eid=" + eid +
                ", ename='" + ename + '\'' +
                ", one_start=" + one_start +
                ", one_end=" + one_end +
                ", two_start=" + two_start +
                ", two_end=" + two_end +
                ", lab=" + lab +
                ", seat_num=" + seat_num +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Experiment(Integer id, Integer eid, String ename, Integer one_start, Integer one_end, Integer two_start, Integer two_end, Integer lab, Integer seat_num, String remark) {
        this.id = id;
        this.eid = eid;
        this.ename = ename;
        this.one_start = one_start;
        this.one_end = one_end;
        this.two_start = two_start;
        this.two_end = two_end;
        this.lab = lab;
        this.seat_num = seat_num;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getOne_start() {
        return one_start;
    }

    public void setOne_start(Integer one_start) {
        this.one_start = one_start;
    }

    public Integer getOne_end() {
        return one_end;
    }

    public void setOne_end(Integer one_end) {
        this.one_end = one_end;
    }

    public Integer getTwo_start() {
        return two_start;
    }

    public void setTwo_start(Integer two_start) {
        this.two_start = two_start;
    }

    public Integer getTwo_end() {
        return two_end;
    }

    public void setTwo_end(Integer two_end) {
        this.two_end = two_end;
    }

    public Integer getLab() {
        return lab;
    }

    public void setLab(Integer lab) {
        this.lab = lab;
    }

    public Integer getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(Integer seat_num) {
        this.seat_num = seat_num;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

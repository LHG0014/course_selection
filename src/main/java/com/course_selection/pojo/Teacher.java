package com.course_selection.pojo;

public class Teacher {
    private Integer id;
    private Integer tid;
    private String tname;
    private String password;

    public Teacher(Integer id, Integer tid, String tname, String password) {
        this.id = id;
        this.tid = tid;
        this.tname = tname;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tid=" + tid +
                ", tname='" + tname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

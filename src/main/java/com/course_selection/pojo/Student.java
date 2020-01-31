package com.course_selection.pojo;

public class Student {
    private int id;
    private Integer sid;
    private String sname;
    private String password;
    private String initial_password;
    private int total_num;
    private int selected_num;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", password='" + password + '\'' +
                ", initial_password='" + initial_password + '\'' +
                ", total_num=" + total_num +
                ", selected_num=" + selected_num +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInitial_password() {
        return initial_password;
    }

    public void setInitial_password(String initial_password) {
        this.initial_password = initial_password;
    }

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public int getSelected_num() {
        return selected_num;
    }

    public void setSelected_num(int selected_num) {
        this.selected_num = selected_num;
    }

    public void selectCourse() {
        selected_num++;
    }

    public void cancelCourse() {
        selected_num--;
    }

    public Student(int id, Integer sid, String sname, String password, String initial_password, int total_num, int selected_num) {
        this.id = id;
        this.sid = sid;
        this.sname = sname;
        this.password = password;
        this.initial_password = initial_password;
        this.total_num = total_num;
        this.selected_num = selected_num;
    }
}

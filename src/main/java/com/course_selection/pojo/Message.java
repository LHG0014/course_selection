package com.course_selection.pojo;

public class Message {
    private int id;
    private int sid;
    private String sname;
    private String time;
    private String to;
    private String content;
    private String reply;
    private String reply_time;

    @Override
    public String toString() {
        return "message{" +
                "id=" + id +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", time='" + time + '\'' +
                ", to='" + to + '\'' +
                ", content='" + content + '\'' +
                ", reply='" + reply + '\'' +
                ", reply_time='" + reply_time + '\'' +
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

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getReply_time() {
        return reply_time;
    }

    public void setReply_time(String reply_time) {
        this.reply_time = reply_time;
    }
}

package com.course_selection.pojo;

public class Mailbox {
    private int id;
    private int sid;
    private String sname;
    private String title;
    private String content;
    private String time;
    private String reply;
    private String reply_timel;

    @Override
    public String toString() {
        return "mailbox{" +
                "id=" + id +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", reply='" + reply + '\'' +
                ", reply_timel='" + reply_timel + '\'' +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getReply_timel() {
        return reply_timel;
    }

    public void setReply_timel(String reply_timel) {
        this.reply_timel = reply_timel;
    }
}

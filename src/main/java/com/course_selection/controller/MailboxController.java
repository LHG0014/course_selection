package com.course_selection.controller;


import com.course_selection.mapper.MailboxMapper;
import com.course_selection.pojo.Mailbox;
import com.course_selection.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
public class MailboxController {

    @Autowired
    MailboxMapper mailboxMapper;

    @RequestMapping("/addMail")
    public String addMail(HttpServletRequest request, HttpServletResponse response, Mailbox c,
                          @Param("sid") Integer sid, @Param("sname") String sname, @Param("title") String title,
                          @Param("content") String content, @Param("time") String time
    ) throws Exception {
        Student student = (Student) request.getSession().getAttribute("student");
        if (null == student) {
            return "login";
        }
        HttpSession session = request.getSession();//获取session内容
        sid=((Student)session.getAttribute("student")).getSid();
        sname=((Student)session.getAttribute("student")).getSname();
        title=c.getTitle();
        content=c.getContent();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        time=sdf.format(d);
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        mailboxMapper.save(sid,sname,title,content,time);
        return "redirect:/mailbox";
    }

}

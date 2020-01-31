package com.course_selection.controller;

import com.course_selection.mapper.LostFoundMapper;
import com.course_selection.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
public class LostFoundController {
    @Autowired
    LostFoundMapper lostfoundMapper;

    @RequestMapping("/asd")
    public String lost(HttpServletRequest request, HttpServletResponse response,
                       @Param("type") String type, @Param("title") String title,
                       @Param("content") String content, @Param("place") String place,
                       @Param("number") String number, @Param("time") Date time,
                       @Param("sid") Integer sid) {
        type = request.getParameter("type");
        title = request.getParameter("title");
        content = request.getParameter("content");
        HttpSession session = request.getSession();//获取session内容
        sid = ((Student) session.getAttribute("student")).getSid();
        number = String.valueOf(sid.intValue());
        place = lostfoundMapper.findastudent(sid).getSname();
        time = new java.sql.Date(new java.util.Date().getTime());
        lostfoundMapper.addlostfound(type, title, content, place, number, time);
        return "redirect:lostfound";
    }
}

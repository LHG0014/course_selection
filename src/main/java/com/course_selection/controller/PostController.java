package com.course_selection.controller;

import com.course_selection.mapper.PostMapper;
import com.course_selection.pojo.PostNote;
import com.course_selection.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostMapper postMapper;

    @RequestMapping("pnotice")
    public String pnotice(HttpServletRequest request, HttpServletResponse response,
                          @Param("sname")String sname, @Param("comment")String comment, @Param("time") Date time, PostNote p) throws ParseException {

        Student student = (Student) request.getSession().getAttribute("student");
        if (null == student) {
            return "login";
        }
        HttpSession session = request.getSession();//获取session内容
        sname=((Student)session.getAttribute("student")).getSname();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        String date=sdf.format(d);
        time=sdf.parse(date);
        comment=p.getComment();
        postMapper.save_notice(comment,sname,time);
        System.out.println("成功保存通知内容");
        return "redirect:teacher_channel";
    }

    @RequestMapping("/delete_notice")
    public String delete_notice(@Param("id")Integer id, HttpServletRequest request,PostNote p) throws Exception{
        HttpSession session = request.getSession();//获取session内容
        System.out.println("成功session");
        id=p.getId();
        System.out.println(id);
        postMapper.delete_notice(id);
        return "redirect:post_notice";
    }
}

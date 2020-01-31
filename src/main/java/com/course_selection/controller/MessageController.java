package com.course_selection.controller;

import com.course_selection.mapper.MessageMapper;
import com.course_selection.pojo.Message;
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
@RequestMapping("/student")
public class MessageController {

    @Autowired
    MessageMapper messageMapper;
    //cx-edit
    @RequestMapping("/message")
    public String message(  HttpServletRequest request, HttpServletResponse response,
                            Model model,
                            @Param("sid") Integer sid
    ) throws  Exception{
        HttpSession session = request.getSession();//获取session内容
        sid=((Student)session.getAttribute("student")).getSid();
        List<Message> messages= messageMapper.findMessage(sid);
        request.getSession(false).setAttribute("mes",messages);
//        model.addAttribute("mes",messages);//-》request...的替代者
        return "message";
    }
    @RequestMapping("/addMessage")
    public String addDiary(HttpServletRequest request, HttpServletResponse response,Message c,
                           @Param("sid") Integer sid, @Param("sname") String sname,@Param("time") String time,
                           @Param("to") String to,@Param("content") String content
    ) throws Exception {
        HttpSession session = request.getSession();//获取session内容
        sid=((Student)session.getAttribute("student")).getSid();
        sname=((Student)session.getAttribute("student")).getSname();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        time=sdf.format(d);
        to=c.getTo();
        content=c.getContent();
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        messageMapper.save(sid,sname,time,to,content);
        return "redirect:/message";
    }
}

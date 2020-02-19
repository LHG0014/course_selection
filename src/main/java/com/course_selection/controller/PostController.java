package com.course_selection.controller;

import com.course_selection.mapper.PostMapper;
import com.course_selection.pojo.Experiment;
import com.course_selection.pojo.PostNote;
import com.course_selection.pojo.Student;
import com.course_selection.pojo.Teacher;
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

    //发布通知
    @RequestMapping("/pnotice")
    public String pnotice(HttpServletRequest request, HttpServletResponse response,
                          @Param("tname")String tname, @Param("comment")String comment, @Param("time") Date time, PostNote p) throws ParseException {
        HttpSession session = request.getSession();//获取session内容
        tname=((Teacher)session.getAttribute("teacher")).getTname();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        String date=sdf.format(d);
        time=sdf.parse(date);
        comment=p.getComment();
        postMapper.save_notice(comment,tname,time);
        return "redirect:homePage_teacher";
    }

    //删除通知
    @RequestMapping("/delete_notice")
    public String delete_notice(@Param("id")Integer id, HttpServletRequest request,PostNote p) throws Exception{
        HttpSession session = request.getSession();//获取session内容
        id=p.getId();
        postMapper.delete_notices(id);
        return "redirect:post_notice";
    }

    //发布注意事项
    @RequestMapping("/pattention")
    public String pattention(HttpServletRequest request, HttpServletResponse response,
                          @Param("tname")String tname, @Param("comment")String comment, @Param("time") Date time, PostNote p) throws ParseException {
        HttpSession session = request.getSession();//获取session内容
        tname=((Teacher)session.getAttribute("teacher")).getTname();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        String date=sdf.format(d);
        time=sdf.parse(date);
        comment=p.getComment();
        postMapper.save_attention(comment,tname,time);
        return "redirect:homePage_teacher";
    }

    //删除注意事项
    @RequestMapping("/delete_attention")
    public String delete_attention(@Param("id")Integer id, PostNote p) throws Exception{
        id=p.getId();
        postMapper.delete_attentions(id);
        return "redirect:post_notes";
    }

    //发布实验室守则
    @RequestMapping("/prules")
    public String prules(HttpServletRequest request, HttpServletResponse response,
                             @Param("tname")String tname, @Param("comment")String comment, @Param("time") Date time, PostNote p) throws ParseException {
        HttpSession session = request.getSession();//获取session内容
        tname=((Teacher)session.getAttribute("teacher")).getTname();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        String date=sdf.format(d);
        time=sdf.parse(date);
        comment=p.getComment();
        postMapper.save_rule(comment,tname,time);
        return "redirect:homePage_teacher";
    }

    //删除实验室守则
    @RequestMapping("/delete_rules")
    public String delete_rules(@Param("id")Integer id, PostNote p) throws Exception{
        id=p.getId();
        postMapper.delete_rule(id);
        return "redirect:post_rules";
    }
    //发布实验开放信息
    @RequestMapping("/popenInfo")
    public String popenInfo(HttpServletRequest request, HttpServletResponse response,
                            @Param("eid") Integer eid, @Param("ename") String ename, @Param("one_start") Integer one_start,
                            @Param("one_end") Integer one_end, @Param("two_start") Integer two_start, @Param("two_end") Integer two_end,
                            @Param("lab") Integer lab, @Param("seat_num") Integer seat_num, @Param("remark") String remark, Experiment e) throws ParseException {
        HttpSession session = request.getSession();//获取session内容
       eid=e.getEid();
       ename=e.getEname();
       one_start=e.getOne_start();
       one_end=e.getOne_end();
       two_end=e.getTwo_end();
       two_start=e.getTwo_start();
       lab=e.getLab();
       seat_num=e.getSeat_num();
       remark=e.getRemark();
        postMapper.save_openInfo(eid,ename,one_start,one_end,two_start,two_end,lab,seat_num,remark);
        return "redirect:homePage_teacher";
    }

    //删除实验室开放信息
    @RequestMapping("/delete_openInfo")
    public String delete_openInfos(@Param("id")Integer id, PostNote p) throws Exception{
        id=p.getId();
        postMapper.delete_openInfo(id);
        return "redirect:post_openInfo";
    }
}

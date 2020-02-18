package com.course_selection.controller;

import com.course_selection.mapper.QueryTeacherExcelMapper;
import com.course_selection.pojo.Teacher_Arrangement;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class QueryTeacherExcelController {
    @Autowired
    QueryTeacherExcelMapper queryTeacherExcelMapper;
    @RequestMapping("/query_teacher_result")
    public String query_teacher_result(@Param("eid")int eid,
                                       Model m,
                                       HttpServletRequest request){
        eid=Integer.parseInt(request.getParameter("eid"));
        List<Teacher_Arrangement> ta=queryTeacherExcelMapper.findteacher(eid);
        for(Teacher_Arrangement t:ta){
            System.out.println(t);
        }
        m.addAttribute("ta",ta);
        return "query_teacher_result";
    }
    @RequestMapping("/update")
    public String updateCategory(HttpServletRequest req) throws Exception {
        Teacher_Arrangement ta=new Teacher_Arrangement();
        ta.setWeek(Integer.parseInt(req.getParameter("week")));
        ta.setSunday_1(req.getParameter("1"));
        ta.setSunday_2(req.getParameter("2"));
        ta.setMonday_1(req.getParameter("3"));
        ta.setMonday_2(req.getParameter("4"));
        ta.setTuesday_1(req.getParameter("5"));
        ta.setTuesday_2(req.getParameter("6"));
        ta.setWednesday_1(req.getParameter("7"));
        ta.setWednesday_2(req.getParameter("8"));
        ta.setThursday_1(req.getParameter("9"));
        ta.setThursday_2(req.getParameter("10"));
        ta.setFriday_1(req.getParameter("11"));
        ta.setFriday_2(req.getParameter("12"));
        ta.setSaturday_1(req.getParameter("13"));
        ta.setSaturday_2(req.getParameter("14"));
        queryTeacherExcelMapper.update(ta);
        System.out.println(ta);
        return "redirect:query_teacher_teacher";
    }
}

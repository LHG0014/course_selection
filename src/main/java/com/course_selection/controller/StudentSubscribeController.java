package com.course_selection.controller;

import com.course_selection.mapper.StudentSubcribeMapper;
import com.course_selection.pojo.Selection_Information;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentSubscribeController {
    @Autowired
    StudentSubcribeMapper studentSubcribeMapper;
    @RequestMapping("/student_subscribe_result")
    public String student_subscribe_result(Model m,
                                           @Param("weeknum")int weeknum,
                                           @Param("eid")int eid,
                                           @Param("day")int day,
                                           @Param("section")int section,
                                           HttpServletRequest request){
        weeknum=Integer.parseInt(request.getParameter("weeknum"));
        eid=Integer.parseInt(request.getParameter("eid"));
        day=Integer.parseInt(request.getParameter("day"));
        section=Integer.parseInt(request.getParameter("section"));
        List<Selection_Information> s=studentSubcribeMapper.findsome(eid,weeknum,day,section);
        m.addAttribute("s",s);
        return "student_subscribe_result";
    }
}

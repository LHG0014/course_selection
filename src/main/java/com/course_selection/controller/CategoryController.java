package com.course_selection.controller;

import com.course_selection.mapper.ExperimentMapper;
import com.course_selection.pojo.Experiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    ExperimentMapper experimentMapper;

    @RequestMapping("/lostfound")
    public String lostfound(){
    	return "lostfound";
    }
    @RequestMapping("/mailbox")
    public String mailbox(){
        return "mailbox";
    }
    @RequestMapping("/message")
    public String message(){
        return "message";
    }
    @RequestMapping("/experiments")
    public String experiments(){
        return "schedule_experiments";
    }
    @RequestMapping("/operating")
    public String operating(){
        return "schedule_operating";
    }
    @RequestMapping("/search")
    public String search(){
        return "search_operating";
    }
    @RequestMapping("/homepage")
    public String homepage(HttpServletRequest request, HttpServletResponse response){
        List<Experiment> experiments=experimentMapper.findAllE();
        request.setAttribute("experiments", experiments);
        return "homePage";
    }
    @RequestMapping("/query_teacher")
    public String query_teacher(){
        return "query_teacher";
    }

}

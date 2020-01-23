package com.course_selection.controller;

import com.course_selection.mapper.ExperimentMapper;
import com.course_selection.mapper.lostfoundMapper;
import com.course_selection.pojo.Experiment;
import com.course_selection.pojo.Lost_Found;
import com.course_selection.pojo.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    lostfoundMapper lostfoundMapper;
    @Autowired
    ExperimentMapper experimentMapper;

    @RequestMapping("/lostfound")
    public String lostfound(Model m,
                            @RequestParam(value = "start", defaultValue = "0")
                                    int start, @RequestParam(value = "size", defaultValue = "5")
                                        int size) throws Exception {
        PageHelper.startPage(start,size,"id asc");//根据start,size进行分页，并且设置id 倒排序
        List<Lost_Found> lf=lostfoundMapper.findalllost_found();
        for(Lost_Found a:lf){
            System.out.println(a);
        }
        PageInfo<Lost_Found> page = new PageInfo<>(lf);//根据返回的集合，创建PageInfo对象
        m.addAttribute("page", page);
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

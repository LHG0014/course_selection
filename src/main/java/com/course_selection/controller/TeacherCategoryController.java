package com.course_selection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TeacherCategoryController {
    @RequestMapping("/query_student_subscribe")
    public String query_student(){
        return "query_student_subscribe";
    }
    @RequestMapping("/student_subscribe_result")
    public String student_subscribe_result(){
        return "student_subscribe_result";
    }
    @RequestMapping("/query_teacher_teacher")
    public String query_teacher(){
        return "query_teacher_teacher";
    }
    @RequestMapping("/query_teacher_result")
    public String query_teacher_result(){
        return "query_teacher_result";
    }
}

package com.course_selection.controller;

import com.course_selection.mapper.ResetMapper;
import com.course_selection.pojo.SetDate;
import com.course_selection.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResetController {
    @Autowired
    ResetMapper resetMapper;

    //重置密码
    @RequestMapping("/reset_pa")
    public String reset(@Param ("sid") int sid,Student stu){
        //教师端登录判断加在了页面跳转处
        sid=stu.getSid();
        resetMapper.reset_password(sid);
        return "redirect:homePage_teacher";
    }

    //设置开学日期
    @RequestMapping("/set_day")
    public String set_day(@Param("date") String date, SetDate setDate){
        //教师端登录判断加在了页面跳转处
        setDate.setDate(setDate.getYear()+"-"+setDate.getMonth()+"-"+setDate.getDay());
        resetMapper.set_day(setDate.getDate());
        return "redirect:homePage_teacher";
    }
}

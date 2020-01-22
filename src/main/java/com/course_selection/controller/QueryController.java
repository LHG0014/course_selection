package com.course_selection.controller;

import com.course_selection.mapper.QueryMapper;
import com.course_selection.pojo.teacher_arrangement;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class QueryController {

    @Autowired
    private QueryMapper queryMapper;

    @RequestMapping("/findT")
    public String findT(HttpServletRequest request, HttpServletResponse response,
                        @Param("eid")Integer eid, @Param("week") Integer week, @Param("section")Integer section,@Param("day")Integer day){
        teacher_arrangement ta=queryMapper.findT(eid, week);
        String tname=null;
        System.out.println(ta);
        if(null == ta)
            tname="";
        else{
            switch(day){
                case 1:
                    if(section == 1)
                        tname = ta.getMonday_1();
                    else if(section == 2)
                        tname= ta.getMonday_2();
                    break;
                case 2:
                    if(section == 1)
                        tname = ta.getTuesday_1();
                    else if(section == 2)
                        tname= ta.getTuesday_2();
                    break;
                case 3:
                    if(section == 1)
                        tname = ta.getWednesday_1();
                    else if(section == 2)
                        tname= ta.getWednesday_2();
                    break;
                case 4:
                    if(section == 1)
                        tname = ta.getThursday_1();
                    else if(section == 2)
                        tname= ta.getThursday_2();
                    break;
                case 5:
                    if(section == 1)
                        tname = ta.getFriday_1();
                    else if(section == 2)
                        tname= ta.getFriday_2();
                    break;
                case 6:
                    if(section == 1)
                        tname = ta.getSaturday_1();
                    else if(section == 2)
                        tname= ta.getSaturday_2();
                    break;
                case 7:
                    if(section == 1)
                        tname = ta.getSunday_1();
                    else if(section == 2)
                        tname= ta.getSunday_2();
                    break;
            }
        }
        System.out.println(tname);
        return tname;
    }
}

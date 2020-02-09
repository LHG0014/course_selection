package com.course_selection.controller;

import com.course_selection.service.impl.QueryServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class QueryController {

    @Autowired
    private QueryServiceImpl queryService;

    @RequestMapping("/queryT")
    public String findT(HttpServletRequest request, HttpServletResponse response,
                        @Param("eid") Integer eid, @Param("week") Integer week, @Param("section") Integer section, @Param("day") Integer day) {
        String result = null;
        result = queryService.queryTeacher(eid, week, day, section);
        System.out.println(result);
        return result;
    }
}

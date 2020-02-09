package com.course_selection.service.impl;

import com.course_selection.mapper.QueryMapper;
import com.course_selection.pojo.Teacher_Arrangement;
import com.course_selection.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryMapper queryMapper;

    @Override
    public String queryTeacher(int eid,int week,int day,int section){
        String result = null;
        Teacher_Arrangement ta = queryMapper.findT(eid, week);
        System.out.println(ta);
        if (null == ta)
            result = "";
        else {
            switch (day) {
                case 1:
                    if (section == 1)
                        result = ta.getMonday_1();
                    else if (section == 2)
                        result = ta.getMonday_2();
                    break;
                case 2:
                    if (section == 1)
                        result = ta.getTuesday_1();
                    else if (section == 2)
                        result = ta.getTuesday_2();
                    break;
                case 3:
                    if (section == 1)
                        result = ta.getWednesday_1();
                    else if (section == 2)
                        result = ta.getWednesday_2();
                    break;
                case 4:
                    if (section == 1)
                        result = ta.getThursday_1();
                    else if (section == 2)
                        result = ta.getThursday_2();
                    break;
                case 5:
                    if (section == 1)
                        result = ta.getFriday_1();
                    else if (section == 2)
                        result = ta.getFriday_2();
                    break;
                case 6:
                    if (section == 1)
                        result = ta.getSaturday_1();
                    else if (section == 2)
                        result = ta.getSaturday_2();
                    break;
                case 7:
                    if (section == 1)
                        result = ta.getSunday_1();
                    else if (section == 2)
                        result = ta.getSunday_2();
                    break;
            }
        }
        return result;
    }
}

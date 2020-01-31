package com.course_selection.service;

import com.course_selection.mapper.ExperimentMapper;
import com.course_selection.mapper.SelectionMapper;
import com.course_selection.pojo.Experiment;
import com.course_selection.pojo.Selection_Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private SelectionMapper selectionMapper;

    @Autowired
    private ExperimentMapper experimentMapper;

    public String seat_count(int eid, int weeknum, int section, int day) {
        String result = "";
        int total = (experimentMapper.findE(eid)).getSeat_num();
        int now = (selectionMapper.findOne(eid, weeknum, section, day)).size();
        System.out.println(total);
        System.out.println(now);
        result = "剩余座位数量:" + (total - now);
        System.out.println(result);
        return result;
    }

    public String select_course(Integer sid, Integer eid, Integer week, Integer day, Integer section) {
        String result = null;
        Experiment experiment = experimentMapper.findE(eid);
        List<Selection_Information> sis = selectionMapper.findOne(eid, week, day, section);
        for (Selection_Information selection_information : selectionMapper.findS(sid)) {
            if (eid == selection_information.getEid()) {
                result = "该课程已选择";
                break;
            }
        }
        if (result != null) {
            return result;
        }
        if (experiment.getSeat_num() == sis.size()) {
            result = "选课人数已满。";
            return result;
        }
        int seat = 1;
        for (Selection_Information selection_information : sis) {
            if (seat == selection_information.getSeat()) {
                seat++;
            } else {
                break;
            }
        }
        selectionMapper.add(sid, eid, experiment.getEname(), week, day, section, experiment.getLab(), seat);
        result = "选课成功";
        return result;
    }

    public String cancel_course(Integer sid, Integer eid) {
        String result = null;
        selectionMapper.delete(sid, eid);
        result = "该课程已取消预约";
        return result;
    }

    public List<Selection_Information> selected(int sid) {
        return selectionMapper.findS(sid);
    }

}

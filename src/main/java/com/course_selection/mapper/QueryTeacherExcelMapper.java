package com.course_selection.mapper;

import com.course_selection.pojo.Teacher_Arrangement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QueryTeacherExcelMapper {
    @Select("select * from teacher_arrangement where eid=#{eid} order by week asc")
    public List<Teacher_Arrangement> findteacher(@Param("eid")int eid);
    @Update("update teacher_arrangement set sunday_1=#{Sunday_1},sunday_2=#{sunday_2},monday_1=#{monday_1},monday_2=#{monday_2},tuesday_1=#{tuesday_1},tuesday_2=#{tuesday_1},wednesday_1=#{wednesday_1},wednesday_2=#{wednesday_2},thursday_1=#{thursday_1},thursday_2=#{thursday_2},friday_1=#{friday_1},friday_2=#{friday_2},saturday_1=#{saturday_1},saturday_2=#{saturday_2} where week=#{week} ")
    public int update(Teacher_Arrangement category);
}
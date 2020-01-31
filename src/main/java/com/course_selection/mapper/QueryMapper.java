package com.course_selection.mapper;

import com.course_selection.pojo.Teacher_Arrangement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QueryMapper {

    @Select("select * from teacher_arrangement where eid=#{eid} and week = #{week}")
    public Teacher_Arrangement findT(@Param("eid") int eid, @Param("week") int week);
}

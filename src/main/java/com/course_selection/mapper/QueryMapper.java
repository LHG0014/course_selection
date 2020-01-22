package com.course_selection.mapper;

import com.course_selection.pojo.teacher_arrangement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QueryMapper {

    @Select("select * from teacher_arrangement where eid=#{eid} and week = #{week}")
    public teacher_arrangement findT(@Param("eid")int eid,@Param("week")int week);
}

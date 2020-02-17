package com.course_selection.mapper;


import com.course_selection.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper {
    @Select("select * from teacher where tid=#{tid}")
    public Teacher findByTid(@Param("tid") Integer tid);
}

package com.course_selection.mapper;

import com.course_selection.pojo.Lost_Found;
import com.course_selection.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
@Mapper
public interface LostFoundMapper {
    @Select("select * from lost_found order by id desc")
    public List<Lost_Found> findalllost_found();

    @Insert("insert into lost_found (id,type,title,content,place,number,time) values (null,#{type},#{title},#{content},#{place},#{number},#{time}) ")
    public void addlostfound(@Param("type") String type, @Param("title") String title,
                             @Param("content") String content, @Param("place") String place,
                             @Param("number") String number, @Param("time") String time);

    @Select("select * from student where sid=#{sid}")
    public Student findastudent(@Param("sid") Integer sid);
}

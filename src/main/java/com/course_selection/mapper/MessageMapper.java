package com.course_selection.mapper;

import com.course_selection.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface MessageMapper{
    @Select("select * from message order by id desc")
    public List<Message> findMessage();
    @Insert("insert into message (sid,sname,time,`to`,content) values( #{sid}, #{sname}, #{time}, #{to}, #{content})")
    public void save(@Param("sid") Integer sid,@Param("sname") String sname,@Param("time") String time,@Param("to") String to,@Param("content")String content);

}

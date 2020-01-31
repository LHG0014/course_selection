package com.course_selection.mapper;


import com.course_selection.pojo.Mailbox;
import com.course_selection.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MailboxMapper {
    @Select("select * from mailbox where sid=#{sid} order by id desc")
    public List<Mailbox> findMail(Integer sid);
    @Insert("insert into mailbox (sid,sname,title,content,time) values( #{sid}, #{sname}, #{title}, #{content}, #{time})")
    public void save(@Param("sid") Integer sid, @Param("sname") String sname, @Param("title") String title, @Param("content") String content, @Param("time")String time);

}

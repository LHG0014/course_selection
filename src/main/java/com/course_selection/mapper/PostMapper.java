package com.course_selection.mapper;

import com.course_selection.pojo.Experiment;
import com.course_selection.pojo.PostNote;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface PostMapper {
    @Insert("insert into notice (comment,publisher,time) values(#{comment},#{publisher},#{time})")
    public void save_notice(@Param("comment") String comment,@Param("publisher") String publisher,@Param("time") Date time);

    @Select("select * from notice order by id desc")
    public List<PostNote> findNotice();

    @Delete("delete from notice where id=#{id}")
    public void delete_notices(@Param("id") Integer id);

    @Insert("insert into attention (comment,publisher,time) values(#{comment},#{publisher},#{time})")
    public void save_attention(@Param("comment") String comment,@Param("publisher") String publisher,@Param("time") Date time);

    @Select("select * from attention order by id desc")
    public List<PostNote> findAttention();

    @Delete("delete from attention where id=#{id}")
    public void delete_attentions(@Param("id") Integer id);

    @Insert("insert into rule (comment,publisher,time) values(#{comment},#{publisher},#{time})")
    public void save_rule(@Param("comment") String comment,@Param("publisher") String publisher,@Param("time") Date time);

    @Select("select * from rule order by id desc")
    public List<PostNote> findRule();

    @Delete("delete from rule where id=#{id}")
    public void delete_rule(@Param("id") Integer id);

    @Insert("insert into experiment (eid,ename,one_start,one_end,two_start,two_end,lab,seat_num,remark) values(#{eid},#{ename},#{one_start},#{one_end},#{two_start},#{two_end},#{lab},#{seat_num},#{remark})")
    public void save_openInfo(@Param("eid") Integer eid,@Param("ename") String ename,@Param("one_start") Integer one_start,
                              @Param("one_end") Integer one_end,@Param("two_start") Integer two_start,@Param("two_end") Integer two_end,
                              @Param("lab") Integer lab,@Param("seat_num") Integer seat_num,@Param("remark") String remark);

    @Select("select * from experiment order by id desc")
    public List<Experiment> findOpenInfo();

    @Delete("delete from experiment where id=#{id}")
    public void delete_openInfo(@Param("id") Integer id);
}

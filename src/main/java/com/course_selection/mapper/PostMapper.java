package com.course_selection.mapper;

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
    public void delete_notice(@Param("id") Integer id);
}

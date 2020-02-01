package com.course_selection.mapper;


import com.course_selection.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    @Select("select * from student")
    public List<Student> findAll();

    @Select("select * from student where sid=#{sid} and password=#{password} ")
    public Student login(@Param("sid") Integer sid, @Param("password") String password);

    @Select("select * from student where sid=#{sid}")
    public Student findBySid(@Param("sid") Integer sid);

    @Update("update student set password=#{password_new} where sid = #{sid} and id=#{id}")
    public void changePassword(@Param("sid") Integer sid, @Param("password") String password, @Param("password_new") String password_new, @Param("id") Integer id);

    @Select("select * from student where sid=#{sid} and password=#{password}")
    public Student findOne(@Param("sid") Integer sid, @Param("password") String password, @Param("sname") String sname);

    @Select("select * from student where id=#{id}")
    public Student findById(@Param("id") Integer id);

    @Update("update student set selected_num=#{selected_num} where sid = #{sid}")
    public void changeCourse(@Param("sid") Integer sid, @Param("selected_num") Integer selected_num);

}

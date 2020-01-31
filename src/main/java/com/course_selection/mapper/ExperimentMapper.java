package com.course_selection.mapper;


import com.course_selection.pojo.Experiment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExperimentMapper {

    @Select("select * from experiment")
    public List<Experiment> findAllE();

    @Select("select * from experiment where eid=#{eid}")
    public Experiment findE(@Param("eid") int eid);
}

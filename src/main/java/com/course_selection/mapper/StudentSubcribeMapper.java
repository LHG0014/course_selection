package com.course_selection.mapper;

import com.course_selection.pojo.Selection_Information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentSubcribeMapper {
    @Select("select * from selection_information where eid=#{eid} and weeknum=#{weeknum} and day=#{day} and section=#{section} order by seat asc")
    public List<Selection_Information> findsome(@Param("eid") int eid, @Param("weeknum") int weeknum, @Param("day") int day, @Param("section") int section);
}

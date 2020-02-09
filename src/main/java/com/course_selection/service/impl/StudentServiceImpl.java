package com.course_selection.service.impl;

import com.course_selection.mapper.StudentMapper;
import com.course_selection.pojo.Student;
import com.course_selection.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student addCourse(Student student) {
        studentMapper.changeCourse(student.getSid(), student.getSelected_num());
        return student;
    }

    @Override
    public Student cancelCourse(Student student) {
        studentMapper.changeCourse(student.getSid(), student.getSelected_num());
        return student;
    }
}

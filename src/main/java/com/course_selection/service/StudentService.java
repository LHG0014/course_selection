package com.course_selection.service;

import com.course_selection.mapper.StudentMapper;
import com.course_selection.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Student addCourse(Student student) {
        student.selectCourse();
        studentMapper.changeCourse(student.getSid(), student.getSelected_num());
        return student;
    }

    public Student cancelCourse(Student student) {
        student.cancelCourse();
        studentMapper.changeCourse(student.getSid(), student.getSelected_num());
        return student;
    }
}

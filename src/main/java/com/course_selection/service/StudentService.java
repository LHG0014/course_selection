package com.course_selection.service;

import com.course_selection.pojo.Student;

public interface StudentService {
    Student addCourse(Student student);

    Student cancelCourse(Student student);
}

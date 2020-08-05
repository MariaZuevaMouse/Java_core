package com.company.mz.streamapi;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StreamApp {
    public List<List<Courses>> studentCourses(List<Student> studentList){
        return studentList.stream()
                .map(student -> student.getAllCources())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Student> mostCuriousStudents(List<Student> studentList){
        return (List<Student>) studentList.stream()
                .map((Function<Student, List<Courses>>) getCoursesOfStudent -> getCoursesOfStudent.getAllCources())
                .sorted()
                .limit(3);
    }

     public List<Student> studentHaveCourses(List<Student> studentList, List<Courses>coursesList){
        return studentList.stream()
                .filter(student -> student.getAllCources().contains(coursesList))
                .collect(Collectors.toList());
     }

    interface Student{
        String getName();
        List<Courses> getAllCources();
    }
    interface Courses {
        String getCourseName();
    }
}




package com.company.mz.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainJson {
    public static void main(String[] args) throws IOException {
//        writeJson();
        ObjectMapper studentMapper = new ObjectMapper();

        Student student1 = studentMapper.readValue(new File("target\\student.json"), Student.class);
        System.out.println(student1.getCoursesList());

    }

    private static void writeJson() throws IOException {
        List<Course> courseList = Arrays.asList(
                new Course(1,"java", "Dmitry"),
                new Course(2, "testing", "Rail"),
                new Course(3, "Linux", "Michail")
        );
        Student student = new Student(
                1,
                "Petr",
                "Ivanov",
                courseList
        );
        ObjectMapper studentMapper = new ObjectMapper();
        studentMapper.writeValue(new File("target\\student.json"), student);
    }
}

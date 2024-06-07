package com.acciojob.LibraryManagementSystem.Service;

import com.acciojob.LibraryManagementSystem.Model.Student;
import com.acciojob.LibraryManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public String addStudent(Student student) {

        studentRepository.save(student);

        return "Student has been saved to DB";
    }
}

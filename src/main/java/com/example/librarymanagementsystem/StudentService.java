package com.example.librarymanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student addStudent(Student student) {
        Student savedStudent = studentRepository.save(student); //query to add something to table
        return savedStudent;
    }

    public Student getStudent(int regNo) {
        Optional<Student> studentOptional = studentRepository.findById(regNo); //query to get the result in the table by giving the primary key
        if(studentOptional.isPresent()) {
            return studentOptional.get();
        }
        return null;
    }
}

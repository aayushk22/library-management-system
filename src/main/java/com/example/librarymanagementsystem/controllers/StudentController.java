package com.example.librarymanagementsystem.controllers;

import com.example.librarymanagementsystem.Enum.CardStatus;
import com.example.librarymanagementsystem.model.LibraryCard;
import com.example.librarymanagementsystem.service.StudentService;
import com.example.librarymanagementsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student) {
        String response = studentService.addStudent(student);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo) {
        Student student = studentService.getStudent(regNo);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.FOUND);
        }

        return new ResponseEntity("Invalid id", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-male-students")
    public List<String> getAllMales() {
        List<String> males = studentService.getAllMales();
        return males;
    }
}

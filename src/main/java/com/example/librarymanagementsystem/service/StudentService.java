package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.Enum.CardStatus;
import com.example.librarymanagementsystem.Enum.Gender;
import com.example.librarymanagementsystem.model.LibraryCard;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {
        //assigning library card to the student
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);

        Student savedStudent = studentRepository.save(student); //query to add something to table
        return "saved Student";
    }

    public Student getStudent(int regNo) {
        Optional<Student> studentOptional = studentRepository.findById(regNo); //query to get the result in the table by giving the primary key
        if(studentOptional.isPresent()) {
            return studentOptional.get();
        }
        return null;
    }

    public List<String> getAllMales() {
        List<String> list = new ArrayList<>();
        List<Student> maleStudents = studentRepository.findByGender(Gender.MALE);
        for (Student s: maleStudents) {
            list.add(s.getName());
        }

        return list;
    }
}

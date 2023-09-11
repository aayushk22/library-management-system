package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter //annotation that will create setter methods for all the attributes
@FieldDefaults(level = AccessLevel.PRIVATE) //this annotation will create every attribute as private by default
@NoArgsConstructor //annotation that will create default constructor
@AllArgsConstructor //annotation that will create all args constructor
@Getter //annotation that will create getter methods for all the attributes
@Entity
@Table(name = "student_info") // change the name of the table but actually this will create a new table

public class Student {


    @Id // this annotation will set this attribute as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //will automatically generate the id by the database
    int regNo;

    String name;

    int age;

    @Column(unique = true, nullable = false) //will not allow user to add a duplicate email or a null value
    String email;

    @Enumerated(EnumType.STRING) //will force the entry in the table to show the exact gender instead of 0/1/2 which is set as default by using the enum
    Gender gender;

    //connecting parent to child
    //cascade will apply the saving function to the table for the library card as well
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL) //one to one relationship b/w student to library card
    LibraryCard libraryCard;
}

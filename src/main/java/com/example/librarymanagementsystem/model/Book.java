package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.Enum.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;

    String title;

    int noOfPages;

    Genre genre;

    double cost;

    @ManyToOne
    @JoinColumn
    Author author;
}

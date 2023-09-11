package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LibraryCard {

    @Id //primary key
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;

    String cardNo;

    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;

    @CreationTimestamp //automatically takes the time from the system and assigns
    Date issueDate;

    @OneToOne //tells that there is one to one relation from library card to student, the first "one" represents the current class
    @JoinColumn //defines the foreign key and picks the primary key of the parent entity by default
    Student student;
}

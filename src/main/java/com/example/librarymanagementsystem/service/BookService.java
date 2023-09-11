package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.exception.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;

    public String addBook(Book book) {
        //check if author exists or not
        Optional<Author> authorOptional = authorRepository.findById(book.getAuthor().getId());
        if (authorOptional.isEmpty()) {
            throw new AuthorNotFoundException("Invalid Author Id");
        }

        Author author = authorOptional.get();
        book.setAuthor(author);
        author.getBooks().add(book);

        authorRepository.save(author); // this will save both author and book
        return "book added successfully";
    }
}

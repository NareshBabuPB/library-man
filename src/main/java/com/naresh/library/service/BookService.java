package com.naresh.library.service;

import com.naresh.library.exceptions.EntityNotFoundException;
import com.naresh.library.model.Book;
import com.naresh.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

  @Autowired
  BookRepository bookRepository;
  
  public List<Book> getAll() {
    return StreamSupport.stream(bookRepository.findAll().spliterator(), false).collect(Collectors.toList());
  }
  
  public Book save(Book p) {
    return bookRepository.save(p);
  }

  public Book findById(Long bookId) {
    return bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found: Book Id: " + bookId));
  }

}

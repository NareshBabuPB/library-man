package com.naresh.library.controller;

import com.naresh.library.model.Book;
import com.naresh.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
  
  @Autowired
  private BookService bookService;
  
  @GetMapping(path ="/api/book")
  public ResponseEntity<List<Book>> getBooks() {
    return ResponseEntity.ok(bookService.getAll());
  }

  @PostMapping(path ="/api/book")
  public ResponseEntity<Book> saveBook(@RequestBody Book book) {
    return ResponseEntity.ok(bookService.save(book));
  }
  
  @GetMapping(path = "/api/book/{book-id}")
  public ResponseEntity<Book> getBookById(@PathVariable(name="book-id",required=true)Long bookId){
    return ResponseEntity.ok(bookService.findById(bookId));
  }

}

package com.naresh.library.controller;

import com.naresh.library.model.Transaction;
import com.naresh.library.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TransactionController {
  
  @Autowired
  TransactionService transactionService;
  
  @PostMapping(path = "/api/transaction")
  public ResponseEntity<Transaction> issueBookToMember(@RequestBody Map<String, Long> params) throws Exception {
    
    Long bookId = params.get("bookId");
    Long memberId = params.get("memberId");

    return ResponseEntity.ok().body(transactionService.issueBook(bookId, memberId));
  }

  @PatchMapping(path= "/api/transaction/{transaction-id}/return")
  public ResponseEntity<Transaction> returnBookTransaction(@PathVariable(name="transaction-id") Long transactionId) throws Exception {

    return ResponseEntity.ok(transactionService.returnBook(transactionId));
  }

}

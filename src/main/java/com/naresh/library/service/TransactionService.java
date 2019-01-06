package com.naresh.library.service;

import com.naresh.library.exceptions.EntityNotFoundException;
import com.naresh.library.model.Book;
import com.naresh.library.model.Member;
import com.naresh.library.model.Transaction;
import com.naresh.library.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookService bookService;

    @Autowired
    MemberService memberService;

    public Transaction issueBook(Long bookId, Long memberId) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setBook(bookService.findById(bookId));
        transaction.setMember(memberService.findById(memberId));
        transaction.setDateOfIssue(LocalDateTime.now());

        if(!isBookAvailable(transaction.getBook())) {
            throw new Exception("Book not available for issue. Book Id: " + transaction.getBook().getId());
        }

        if(findActiveIssuesByMember(transaction.getMember()).size() >= 5) {
            throw new Exception("Member reached max quota of books to be actively issued.");
        }
        return transactionRepository.save(transaction);
    }

    public Transaction returnBook(Long transactionId) throws Exception {
        Transaction transaction = findById(transactionId);
        if(Optional.ofNullable(transaction.getDateOfReturn()).isPresent()) {
            throw new Exception("Transaction already completed. Transaction Id: " + transactionId);
        }
        transaction.setDateOfReturn(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    public Transaction findById(Long transactionId) {
        return transactionRepository.findById(transactionId).orElseThrow(() -> new EntityNotFoundException("Transaction not found: Transaction Id: " + transactionId));
    }

    private boolean isBookAvailable(Book book) {
        return !transactionRepository.findActiveIssueByBookId(book).isPresent();
    }

    private List<Transaction> findActiveIssuesByMember(Member member) {
        return transactionRepository.findActiveIssueByMemberId(member);
    }

}

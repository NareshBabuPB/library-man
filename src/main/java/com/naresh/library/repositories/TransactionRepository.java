package com.naresh.library.repositories;

import com.naresh.library.model.Book;
import com.naresh.library.model.Member;
import com.naresh.library.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query("SELECT trxn FROM Transaction trxn WHERE trxn.book = :book and trxn.dateOfReturn is null")
    Optional<Transaction> findActiveIssueByBookId(@Param("book") Book book);

    @Query("Select trxn from Transaction trxn where trxn.member = :member and trxn.dateOfReturn is null")
    List<Transaction> findActiveIssueByMemberId(@Param("member") Member member);
}

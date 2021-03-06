package com.naresh.library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name="transaction")
public class Transaction implements Serializable {

  private static final long serialVersionUID = 8951221480021840448L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  
  @OneToOne
  @JoinColumn(name = "book_id", referencedColumnName = "id")
  Book book;
  
  @OneToOne
  @JoinColumn(name="member_id", referencedColumnName="id")
  Member member;

  @Column(name="date_of_issue")
  LocalDateTime dateOfIssue;
  
  @Column(name="date_of_return")
  LocalDateTime dateOfReturn;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public LocalDateTime getDateOfIssue() {
    return dateOfIssue;
  }

  public void setDateOfIssue(LocalDateTime dateOfIssue) {
    this.dateOfIssue = dateOfIssue;
  }

  public LocalDateTime getDateOfReturn() {
    return dateOfReturn;
  }

  public void setDateOfReturn(LocalDateTime dateOfReturn) {
    this.dateOfReturn = dateOfReturn;
  }

  @Override
  public String toString() {
    return "Transaction [id=" + id + ", book=" + book + ", member=" + member + ", dateOfIssue=" + dateOfIssue + ", dateOfReturn=" + dateOfReturn + "]";
  }

}

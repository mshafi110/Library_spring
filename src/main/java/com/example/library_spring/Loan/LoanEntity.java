package com.example.library_spring.Loan;

import com.example.library_spring.book.BookEntity;
import com.example.library_spring.person.PersonEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "loan")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long  id;
@OneToOne
@JoinColumn(name = "Book_id")
    BookEntity book;
@OneToOne
@JoinColumn(name = "Person_id")
PersonEntity person;


    String loan;
    Date loanDate;
    Date returnDate;


}

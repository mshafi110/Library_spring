
package com.example.library_spring.Loan;

import com.example.library_spring.book.BookEntity;
import com.example.library_spring.person.PersonEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "Loan")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PersonEntity person;

    @ManyToOne
    private BookEntity book;

    private LocalDate loanDate;
    private LocalDate returnDate;

    private boolean returned;
}

package com.example.library_spring.Loan;

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
public class LaonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long  id;

    String book;
    String person;
    String loan;
    Date loanDate;
    Date returnDate;

}

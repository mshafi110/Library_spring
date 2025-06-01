package com.example.library_spring.person;

import com.example.library_spring.book.BookEntity;
import com.example.library_spring.library.LibraryEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "person")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long  id;

    String firstName;
    String lastName;
    String phoneNumber;
}

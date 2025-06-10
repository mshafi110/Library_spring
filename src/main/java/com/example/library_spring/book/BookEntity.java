package com.example.library_spring.book;

import com.example.library_spring.library.LibraryEntity;
import com.example.library_spring.person.PersonEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "books")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    String author;
    String isbn;
    String genre;
    Boolean available = true;

    @ManyToOne
    @JoinColumn(name = "library_id")
    LibraryEntity library;
    @ManyToOne
    @JoinColumn(name = "book_id")
    BookEntity book;

    public boolean isAvailable() {
        return available;
    }
}

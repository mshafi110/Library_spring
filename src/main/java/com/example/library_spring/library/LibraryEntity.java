package com.example.library_spring.library;

import com.example.library_spring.book.BookEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "libraries")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibraryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToMany(
            mappedBy = "library",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BookEntity> books;
}

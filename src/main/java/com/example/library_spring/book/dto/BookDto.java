package com.example.library_spring.book.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDto {
    Long id;

    String title;
    String author;
    String isbn;
    String genre;
    Boolean available;
}

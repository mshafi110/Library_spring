package com.example.library_spring.book;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {
    BookService bookService;

    @GetMapping
    public List<BookEntity> getBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<BookEntity> getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public BookEntity createBook(@RequestBody BookEntity book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public BookEntity updateBook(@PathVariable Long id, @RequestBody BookEntity book) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}

package com.example.library_spring.library;

import com.example.library_spring.book.BookEntity;
import com.example.library_spring.book.dto.BookDto;
import com.example.library_spring.library.dto.LibraryDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LibraryController {
    LibraryService libraryService;

    @GetMapping
    public List<LibraryDto> getLibraries() {
        return libraryService.findAll();
    }

    @GetMapping("/books/{id}")
    public List<BookDto> getLibraryBooks(@PathVariable Long id) {
        return libraryService.getLibraryBooks(id);
    }

    @GetMapping("/{id}")
    public Optional<LibraryEntity> getLibraryById(@PathVariable Long id) {
        return libraryService.findById(id);
    }

    @PostMapping
    public LibraryEntity createLibrary(@RequestBody LibraryEntity library) {
        return libraryService.save(library);
    }

    @PutMapping("/{id}")
    public LibraryEntity updateLibrary(@PathVariable Long id, @RequestBody LibraryEntity library) {
        return libraryService.update(id, library);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Long id) {
        libraryService.delete(id);
    }
}

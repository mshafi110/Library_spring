package com.example.library_spring.library;

import com.example.library_spring.book.BookEntity;
import com.example.library_spring.book.dto.BookDto;
import com.example.library_spring.library.dto.LibraryDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LibraryService {
    LibraryRepository libraryRepository;

    public List<LibraryDto> findAll() {
        return libraryRepository.findAll().stream()
                .map(libraryEntity -> LibraryDto.builder()
                        .id(libraryEntity.getId())
                        .name(libraryEntity.getName())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public List<BookDto> getLibraryBooks(@PathVariable Long id) {
        Optional<LibraryEntity> library = findById(id);

        if(library.isEmpty()) {
            throw new EntityNotFoundException("Library is empty");

        }
        return library.get().getBooks().stream()
                .map(bookEntity -> BookDto.builder()
                        .id(bookEntity.getId())
                        .title(bookEntity.getTitle())
                        .isbn(bookEntity.getIsbn())
                        .author(bookEntity.getAuthor())
                        .genre(bookEntity.getGenre())
                        .available(bookEntity.getAvailable())
                        .build())
                .toList();
    }

    public LibraryEntity save(LibraryEntity libraryEntity) {
        return libraryRepository.save(libraryEntity);
    }

    public Optional<LibraryEntity> findById(Long id) {
        return libraryRepository.findById(id);
    }

    public void delete(Long id) {
        Optional<LibraryEntity> libraryEntityOptional = libraryRepository.findById(id);

        if (libraryEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Library is empty");
        }


        libraryRepository.delete(libraryEntityOptional.get());
    }

    public LibraryEntity update(Long id, LibraryEntity libraryEntity) {
        Optional<LibraryEntity> libraryEntityOptional = libraryRepository.findById(id);

        if (libraryEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Book is empty");
        }

        LibraryEntity libraryEntityToUpdate = libraryEntityOptional.get();

        if (libraryEntity.getName() != null) {
            libraryEntityToUpdate.setName(libraryEntity.getName());
        }

        if (libraryEntity.getBooks() != null) {
            libraryEntityToUpdate.setBooks(libraryEntity.getBooks());
        }

        return libraryRepository.save(libraryEntityToUpdate);
    }
}

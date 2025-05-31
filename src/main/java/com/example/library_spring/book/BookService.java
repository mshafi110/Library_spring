package com.example.library_spring.book;

import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookService {
    BookRepository bookRepository;

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public BookEntity save(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    public Optional<BookEntity> findById(Long id) {
        return bookRepository.findById(id);
    }

    public void delete(Long id) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(id);

        if (bookEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Book is empty");
        }


        bookRepository.delete(bookEntityOptional.get());
    }

    public BookEntity update(Long id, BookEntity bookEntity) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(id);

        if (bookEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Book is empty");
        }

        BookEntity bookEntityToUpdate = bookEntityOptional.get();

        if(bookEntity.getAuthor() != null){
            bookEntityToUpdate.setAuthor(bookEntity.getAuthor());
        }

        if(bookEntity.getTitle() != null){
            bookEntityToUpdate.setTitle(bookEntity.getTitle());
        }

        return bookRepository.save(bookEntityToUpdate);
    }
}

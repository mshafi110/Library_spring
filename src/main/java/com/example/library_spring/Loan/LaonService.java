package com.example.library_spring.Loan;

import com.example.library_spring.book.BookEntity;
import com.example.library_spring.book.BookService;
import com.example.library_spring.person.PersonEntity;
import com.example.library_spring.person.PersonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LaonService {

    LaonRepository laonRepository;
    private final PersonService personService;
    private final BookService bookService;

    public List<LaonEntity> findAll() {

        return laonRepository.findAll();
    }

    public LaonEntity borrowBook(LaonEntity laonEntity) {
        Long bookId = laonEntity.getBookId();
        Long personId = laonEntity.getPersonId();

        BookEntity book = bookService.findById(bookId);
        PersonEntity person = personService.findById(personId);

        if (book != null && person != null && book.isAvailable()) {
            book.setAvailable(false); // تغییر وضعیت کتاب به "امانت داده شده"
            bookService.save(book);   // ذخیره‌سازی وضعیت جدید کتاب

            laonEntity.setBorrowDate(new Date()); // ثبت تاریخ امانت
            LaonEntity savedLoan = laonRepository.save(laonEntity); // ذخیره وام در دیتابیس

            System.out.println("کتاب با موفقیت امانت داده شد.");
            return savedLoan;
        } else {
            System.out.println("امانت کتاب امکان‌پذیر نیست.");
            return null;
        }
    }


    
}

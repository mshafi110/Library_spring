package com.example.library_spring.Loan;

import com.example.library_spring.person.PersonEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Laon")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LaonController {

    LaonService laonService;

    @GetMapping//search
    public List<LaonEntity> getLaons() {
        return laonService.findAll();
    }

    @GetMapping("/{id}")//search
    public ResponseEntity<LaonEntity> getLaonById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(laonService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/borrow") // مشخص‌کردن مسیر
    public ResponseEntity<LaonEntity> borrowBook(@RequestBody LaonEntity laon) {
        LaonEntity savedLaon = laonService.save(laon);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLaon);
    }


    @PutMapping("/{id}")  //update
    public ResponseEntity<LaonEntity> updateLaon(@PathVariable Long id, @RequestBody LaonEntity Laon) {
        try {
            LaonEntity updatedLaon = laonService.update(id, Laon);
            return ResponseEntity.ok(updatedLaon);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaon(@PathVariable Long id) {
        try {
            laonService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

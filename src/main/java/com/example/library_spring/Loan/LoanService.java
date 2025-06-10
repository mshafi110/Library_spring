
package com.example.library_spring.Loan;

import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LoanService {
    LoanEntity createLoan(LoanEntity loan);
    List<LoanEntity> getAllLoans();
    LoanEntity getLoanById(Long id);
    LoanEntity updateLoan(Long id, LoanEntity loan);
    void deleteLoan(Long id);
    List<LoanEntity> getActiveLoans();
}






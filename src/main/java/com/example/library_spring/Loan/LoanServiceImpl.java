package com.example.library_spring.Loan;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoanServiceImpl implements LoanService {

    LoanRepository loanRepository;

    @Override
    public LoanEntity createLoan(LoanEntity loan) {
        return loanRepository.save(loan);
    }

    @Override
    public List<LoanEntity> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public LoanEntity getLoanById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    @Override
    public LoanEntity updateLoan(Long id, LoanEntity loan) {
        LoanEntity existing = getLoanById(id);
        if (existing != null) {
            existing.setBook(loan.getBook());
            existing.setPerson(loan.getPerson());
            existing.setLoanDate(loan.getLoanDate());
            existing.setReturnDate(loan.getReturnDate());
            existing.setReturned(loan.isReturned());
            return loanRepository.save(existing);
        }
        return null;
    }

    // گرفتن bookid و persionid و true کردن returned

    @Override
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    @Override
    public List<LoanEntity> getActiveLoans() {
        return loanRepository.findByReturnedFalse();
    }
}

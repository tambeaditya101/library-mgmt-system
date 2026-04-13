package services;

import models.Book;
import models.Loan;
import models.Patron;

import java.util.ArrayList;
import java.util.List;

public class LoanService {

    private List<Loan> loans;

    public LoanService() {
        this.loans = new ArrayList<>();
    }

    // Borrow a book
    public void checkoutBook(Book book, Patron patron) {

        if (book == null || patron == null) {
            System.out.println("Invalid book or patron");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed");
            return;
        }

        Loan loan = new Loan(book, patron);

        loans.add(loan);
        patron.addLoan(loan);
        book.markBorrowed();

        System.out.println("Book borrowed successfully: " + book.getTitle());
    }


    // Return a book
    public void returnBook(Book book, Patron patron) {

        if (book == null || patron == null) {
            System.out.println("Invalid book or patron");
            return;
        }

        for (Loan loan : loans) {

            if (loan.getBook().equals(book)
                    && loan.getPatron().equals(patron)
                    && !loan.isReturned()) {

                loan.markReturned();
                book.markReturned();

                System.out.println("Book returned successfully: " + book.getTitle());
                return;
            }
        }

        System.out.println("No active loan found for this book and patron");
    }


    // View all loans
    public List<Loan> getAllLoans() {
        return loans;
    }


    // View active loans
    public List<Loan> getActiveLoans() {

        List<Loan> activeLoans = new ArrayList<>();

        for (Loan loan : loans) {
            if (!loan.isReturned()) {
                activeLoans.add(loan);
            }
        }

        return activeLoans;
    }
}
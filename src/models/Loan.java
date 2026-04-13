package models;

import java.time.LocalDate;

public class Loan {

    private final Book book;
    private final Patron patron;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean returned;

    public Loan(Book book, Patron patron) {
        this.book = book;
        this.patron = patron;
        this.borrowDate = LocalDate.now();
        this.returned = false;
    }

    public Book getBook() {
        return book;
    }

    public Patron getPatron() {
        return patron;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void markReturned() {
        this.returned = true;
        this.returnDate = LocalDate.now();
    }
}
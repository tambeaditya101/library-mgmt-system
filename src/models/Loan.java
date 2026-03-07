package models;

import java.time.LocalDate;

public class Loan {

    private Book book;
    private Patron patron;
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

    public boolean isReturned() {
        return returned;
    }

    public void markReturned() {
        this.returned = true;
        this.returnDate = LocalDate.now();
    }
}
package services;

import models.Book;
import models.Patron;
import models.Loan;

import java.util.*;

public class LibraryService {

    private Map<String, Book> books = new HashMap<>();
    private Map<String, Patron> patrons = new HashMap<>();
    private List<Loan> loans = new ArrayList<>();


    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public Patron getPatron(String id) {
        return patrons.get(id);
    }

    public void checkoutBook(String isbn, String patronId) {

        Book book = books.get(isbn);
        Patron patron = patrons.get(patronId);

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (patron == null) {
            System.out.println("Patron not found");
            return;
        }

        if (!book.getAvailablity()) {
            System.out.println("Book already borrowed");
            return;
        }

        Loan loan = new Loan(book, patron);

        loans.add(loan);
        patron.addLoan(loan);
        book.markBorrowed();

        System.out.println("Book checked out successfully");
    }

    public void returnBook(String isbn, String patronId) {

        for (Loan loan : loans) {

            if (loan.getBook().getIsbn().equals(isbn)
                    && loan.getPatron().getId().equals(patronId)
                    && !loan.isReturned()) {

                loan.markReturned();
                loan.getBook().markReturned();

                System.out.println("Book returned successfully");
                return;
            }
        }

        System.out.println("Loan record not found");
    }

    public List<Book> searchByTitle(String title) {

        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {

            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }

        return result;
    }
}
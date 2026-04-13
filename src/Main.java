import models.Book;
import models.Patron;
import services.BookService;
import services.LoanService;
import services.PatronService;
import strategies.SearchStrategy;
import strategies.TitleSearchStrategy;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Services
        BookService bookService = new BookService();
        PatronService patronService = new PatronService();
        LoanService loanService = new LoanService();

        // Create book
        Book book = new Book("Clean Code", "Robert Martin", "123", 2008);

        // Create patrons
        Patron patron1 = new Patron("P1", "Aditya", "aditya@test.com");
        Patron patron2 = new Patron("P2", "Rahul", "rahul@test.com");

        // Add to system
        bookService.addBook(book);
        patronService.addPatron(patron1);
        patronService.addPatron(patron2);

        System.out.println("---- Borrow Book ----");

        // Patron1 borrows the book
        loanService.checkoutBook(
                bookService.getBook("123"),
                patronService.getPatron("P1")
        );

        System.out.println("\n---- Second Patron tries to borrow ----");

        // Patron2 tries to borrow (should fail)
        loanService.checkoutBook(
                bookService.getBook("123"),
                patronService.getPatron("P2")
        );

        System.out.println("\n---- Patron2 reserves the book ----");

        // Patron2 reserves the book (Observer)
        bookService.getBook("123").addObserver(patron2);

        System.out.println("\n---- Returning Book ----");

        // Patron1 returns the book
        loanService.returnBook(
                bookService.getBook("123"),
                patronService.getPatron("P1")
        );

        System.out.println("\n---- Search Example ----");

        // Test strategy search
        SearchStrategy strategy = new TitleSearchStrategy();

        List<Book> results = bookService.searchBooks(strategy, "clean");

        for (Book bk : results) {
            System.out.println(bk);
        }
    }
}
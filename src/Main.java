import models.Book;
import models.Patron;
import services.LibraryService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        LibraryService library = new LibraryService();

        Book book1 = new Book("Clean Code", "Robert Martin", "123", 2008);
        Patron patron1 = new Patron("P1", "Aditya", "aditya@mail.com");

        Book book2 = new Book("Clean Code", "Robert Martin", "123", 2006);
        Patron patron2 = new Patron("P2", "Aamir", "aamir@mail.com");

        library.addBook(book1);
        library.addPatron(patron1);
        library.addBook(book2);
        library.addPatron(patron2);
        List<Book> books = library.searchByTitle("Clean Code");
        System.out.println(books);

        library.checkoutBook("123", "P1");

        library.returnBook("123", "P1");
    }
}
package services;

import models.Book;
import java.util.*;
import strategies.SearchStrategy;

public class BookService {

    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }

    public void removeBook(String isbn) {

        if (books.remove(isbn) != null) {
            System.out.println("Book removed successfully");
        } else {
            System.out.println("Book not found");
        }
    }

    public void updateBook(String isbn, String title, String author, int year) {

        Book book = books.get(isbn);

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        book.setTitle(title);
        book.setAuthor(author);
        book.setPublicationYear(year);

        System.out.println("Book updated successfully");
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

    public List<Book> searchByAuthor(String author) {

        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {

            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(book);
            }
        }

        return result;
    }

    public Book searchByIsbn(String isbn) {
        return books.get(isbn);
    }

    public List<Book> searchBooks(SearchStrategy strategy, String query) {

        List<Book> allBooks = new ArrayList<>(books.values());

        return strategy.search(allBooks, query);
    }
}
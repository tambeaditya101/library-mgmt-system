package models;

public class Book {
    //title, author, ISBN, and publication year.
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private boolean available;

    public  Book(String title, String author, String isbn, int publicationYear){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }


    public boolean getAvailablity() {
        return available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void markBorrowed(){
        this.available = false;
    }

    public void markReturned(){
        this.available = true;
    }

    @Override
    public String toString(){
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}

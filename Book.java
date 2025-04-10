package models;

public class Book {
    public String isbn;
    public String title;
    public String author;
    public boolean isAvailable;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String toString() {
        return String.format("%s - %s by %s [%s]", isbn, title, author, isAvailable ? "Available" : "Borrowed");
    }
}

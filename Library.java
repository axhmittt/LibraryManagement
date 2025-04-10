package services;

import models.Book;
import models.BorrowTransaction;
import models.Member;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    List<BorrowTransaction> transactions = new ArrayList<>();

    public void addBook(String isbn, String title, String author) {
        books.add(new Book(isbn, title, author));
    }

    public void addMember(String id, String name) {
        members.add(new Member(id, name));
    }

    public boolean issueBook(String memberId, String isbn) {
        Book book = findBook(isbn);
        if (book != null && book.isAvailable) {
            book.isAvailable = false;
            transactions.add(new BorrowTransaction(memberId, isbn));
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        for (BorrowTransaction bt : transactions) {
            if (bt.isbn.equals(isbn) && bt.returnDate == null) {
                bt.returnBook();
                Book book = findBook(isbn);
                if (book != null) book.isAvailable = true;
                return true;
            }
        }
        return false;
    }

    public List<Book> getBooks() {
        return books;
    }

    private Book findBook(String isbn) {
        for (Book b : books) {
            if (b.isbn.equals(isbn)) return b;
        }
        return null;
    }
}

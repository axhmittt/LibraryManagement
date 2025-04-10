package models;

import java.time.LocalDate;

public class BorrowTransaction {
    public String memberId;
    public String isbn;
    public LocalDate issueDate;
    public LocalDate returnDate;

    public BorrowTransaction(String memberId, String isbn) {
        this.memberId = memberId;
        this.isbn = isbn;
        this.issueDate = LocalDate.now();
        this.returnDate = null;
    }

    public void returnBook() {
        this.returnDate = LocalDate.now();
    }

    public String toString() {
        return memberId + " borrowed " + isbn + " on " + issueDate +
                (returnDate != null ? ", returned on " + returnDate : " (Not returned)");
    }
}

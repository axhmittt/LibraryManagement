package ui;

import models.Book;
import services.Library;

import javax.swing.*;
import java.awt.*;

public class LibraryApp extends JFrame {
    Library library = new Library();

    public LibraryApp() {
        setTitle("Library Management System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton addBookBtn = new JButton("Add Book");
        JButton addMemberBtn = new JButton("Add Member");
        JButton issueBookBtn = new JButton("Issue Book");
        JButton returnBookBtn = new JButton("Return Book");
        JButton viewBooksBtn = new JButton("View All Books");

        addBookBtn.addActionListener(e -> addBook());
        addMemberBtn.addActionListener(e -> addMember());
        issueBookBtn.addActionListener(e -> issueBook());
        returnBookBtn.addActionListener(e -> returnBook());
        viewBooksBtn.addActionListener(e -> viewBooks());

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.add(addBookBtn);
        panel.add(addMemberBtn);
        panel.add(issueBookBtn);
        panel.add(returnBookBtn);
        panel.add(viewBooksBtn);

        add(panel);
        setVisible(true);
    }

    private void addBook() {
        String isbn = JOptionPane.showInputDialog("Enter ISBN:");
        String title = JOptionPane.showInputDialog("Enter Title:");
        String author = JOptionPane.showInputDialog("Enter Author:");
        if (isbn != null && title != null && author != null) {
            library.addBook(isbn, title, author);
            JOptionPane.showMessageDialog(this, "Book added!");
        }
    }

    private void addMember() {
        String id = JOptionPane.showInputDialog("Enter Member ID:");
        String name = JOptionPane.showInputDialog("Enter Name:");
        if (id != null && name != null) {
            library.addMember(id, name);
            JOptionPane.showMessageDialog(this, "Member added!");
        }
    }

    private void issueBook() {
        String memberId = JOptionPane.showInputDialog("Enter Member ID:");
        String isbn = JOptionPane.showInputDialog("Enter Book ISBN:");
        if (library.issueBook(memberId, isbn)) {
            JOptionPane.showMessageDialog(this, "Book issued!");
        } else {
            JOptionPane.showMessageDialog(this, "Issue failed.");
        }
    }

    private void returnBook() {
        String isbn = JOptionPane.showInputDialog("Enter Book ISBN:");
        if (library.returnBook(isbn)) {
            JOptionPane.showMessageDialog(this, "Book returned!");
        } else {
            JOptionPane.showMessageDialog(this, "Return failed.");
        }
    }

    private void viewBooks() {
        StringBuilder sb = new StringBuilder();
        for (Book b : library.getBooks()) {
            sb.append(b).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No books found.");
    }
}

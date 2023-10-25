package org.example;

import org.example.model.Book;
import org.example.model.BorrowedBook;
import org.example.model.Reader;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    private final static String jdbcUrl = "jdbc:mysql://localhost/library";
    private final static String username = "root";
    private final static String password = "root";
    private static Connection connection;

    public static void main(String[] args) throws SQLException {

        connection = DriverManager.getConnection(jdbcUrl, username, password);

        ArrayList<Reader> readersList = loadReaders();
        ArrayList<Book> booksList = loadBooks();
        ArrayList<BorrowedBook> borrowedBooksList = loadBorrowedBooks();

        System.out.println("Содержимое таблицы 'Readers':");
        for (Reader reader : readersList) {
            System.out.println(reader);
        }

        System.out.println("\nСодержимое таблицы 'Books':");
        for (Book book : booksList) {
            System.out.println(book);
        }

        System.out.println("\nСодержимое таблицы 'BorrowedBooks':");
        for (BorrowedBook borrowedBook : borrowedBooksList) {
            System.out.println(borrowedBook);
        }

        connection.close();

    }

    private static ArrayList<Reader> loadReaders() throws SQLException {
        ArrayList<Reader> readersList = new ArrayList<>();
        Statement readerStatement = connection.createStatement();
        ResultSet readerResultSet = readerStatement.executeQuery("SELECT * FROM Readers");
        while (readerResultSet.next()) {
            Reader reader = new Reader();
            reader.setReaderID(readerResultSet.getInt("ReaderID"));
            reader.setFirstName(readerResultSet.getString("FirstName"));
            reader.setLastName(readerResultSet.getString("LastName"));
            reader.setEmail(readerResultSet.getString("Email"));
            reader.setPhoneNumber(readerResultSet.getString("PhoneNumber"));
            readersList.add(reader);
        }
        readerResultSet.close();
        readerStatement.close();
        return readersList;
    }

    private static ArrayList<BorrowedBook> loadBorrowedBooks() throws SQLException {
        ArrayList<BorrowedBook> borrowedBooksList = new ArrayList<>();
        Statement borrowedBooksStatement = connection.createStatement();
        ResultSet borrowedBooksResultSet = borrowedBooksStatement.executeQuery("SELECT * FROM BorrowedBooks");
        while (borrowedBooksResultSet.next()) {
            BorrowedBook borrowedBook = new BorrowedBook();
            borrowedBook.setBorrowID(borrowedBooksResultSet.getInt("BorrowID"));
            borrowedBook.setReaderID(borrowedBooksResultSet.getInt("ReaderID"));
            borrowedBook.setBookID(borrowedBooksResultSet.getInt("BookID"));
            borrowedBook.setBorrowDate(borrowedBooksResultSet.getDate("BorrowDate"));
            borrowedBook.setReturnDate(borrowedBooksResultSet.getDate("ReturnDate"));
            borrowedBooksList.add(borrowedBook);
        }
        borrowedBooksStatement.close();
        borrowedBooksResultSet.close();
        return borrowedBooksList;
    }


    private static ArrayList<Book> loadBooks() throws SQLException {
        ArrayList<Book> booksList = new ArrayList<>();
        Statement bookStatement = connection.createStatement();
        ResultSet bookResultSet = bookStatement.executeQuery("SELECT * FROM Books");
        while (bookResultSet.next()) {
            Book book = new Book();
            book.setBookID(bookResultSet.getInt("BookID"));
            book.setTitle(bookResultSet.getString("Title"));
            book.setAuthor(bookResultSet.getString("Author"));
            book.setPublicationYear(bookResultSet.getInt("PublicationYear"));
            book.setISBN(bookResultSet.getString("ISBN"));
            booksList.add(book);
        }
        bookStatement.close();
        bookResultSet.close();
        return booksList;
    }


}

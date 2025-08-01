package ch03;

import java.util.ArrayList;
import java.util.List;

public class UserInteraction {
    public static void main(String[] args) {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", "1234");
        Book book2 = new EBook("The Aeneid", "Virgil", "9871", 300, "kindle");
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);

        library.getBooks().forEach(System.out::println);
    }
}

class Book {
    String title;
    String author;
    String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    private String getTitle() { return title; }
    private String getAuthor() { return author; }
    private String getIsbn() { return isbn; }

    @Override
    public String toString() { return getTitle() + " " + getAuthor() + " " + getIsbn(); }
}

class EBook extends Book {
    int size;
    String format;

    EBook(String title, String author, String isbn, int size, String format) {
        super(title, author, isbn);
        this.size = size;
        this.format = format;
    }

    int getSize() { return size; }
    String getFormat() { return format; }

    @Override
    public String toString() {
        return super.toString() + " " + getSize() + " " + getFormat();
    }
}

class Library {
    List<Book> books;

    Library() { books = new ArrayList<>(); }
    void addBook(Book book) { books.add(book); }
    List<Book> getBooks() { return books; }
}

package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books;
    public static List<BookReservation> reservations;
    public static List<Author> authors;

    @PostConstruct
    public void init(){
        books = new ArrayList<>();
        reservations = new ArrayList<>();
        authors = new ArrayList<>();

        Author author1 = new Author("Fjodor", "Dostoevsky", "Russia", "Realism author");
        Author author2 = new Author("Lav", "Tolstoy", "Russia", "Realism author");
        Author author3 = new Author("Jane", "Austen", "England", "Romance author");

        authors.add(author1);
        authors.add(author2);
        authors.add(author3);

        books.add(new Book("Crime and Punishment", "Realism", 10.0, author1));
        books.add(new Book("The Brothers Karamazov", "Realism", 10.0, author1));
        books.add(new Book("Ana Karenina", "Realism", 9.5, author2));
        books.add(new Book("War and Peace", "Realism", 9.5, author2));
        books.add(new Book("Pride and Prejudice", "Romance", 8.0, author3));
        books.add(new Book("Miserable People", "Realism", 8.5, author1));
        books.add(new Book("Harry Potter and the Chamber of Secrets", "Fantasy", 10.0, author3));
    }
}

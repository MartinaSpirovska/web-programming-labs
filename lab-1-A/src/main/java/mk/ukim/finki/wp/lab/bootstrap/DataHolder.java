package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books;
    public static List<BookReservation> reservations;

    @PostConstruct
    public void init(){
        books = new ArrayList<>();
        reservations = new ArrayList<>();

        books.add(new Book("Crime and Punishment", "Realism", 10.0));
        books.add(new Book("The Brothers Karamazov", "Realism", 10.0));
        books.add(new Book("Ana Karenina", "Realism", 9.5));
        books.add(new Book("War and Peace", "Realism", 9.5));
        books.add(new Book("Pride and Prejudice", "Romance", 8.0));
        books.add(new Book("Miserable People", "Realism", 8.5));
        books.add(new Book("Harry Potter and the Chamber of Secrets", "Fantasy", 10.0));
    }
}

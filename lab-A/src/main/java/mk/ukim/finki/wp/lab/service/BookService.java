package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
    Book findById(Long id);
    Book save(String title, String genre, Double averageRating, Author author);
    Book update(Long id, String title, String genre, Double averageRating, Author author);
    void deleteById(Long id);
}

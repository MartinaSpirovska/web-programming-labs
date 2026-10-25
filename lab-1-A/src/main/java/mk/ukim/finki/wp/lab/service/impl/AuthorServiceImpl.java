package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.exceptions.AuthorDoesntExistException;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new AuthorDoesntExistException(id));
    }

    @Override
    public Author add(String name, String surname, String country, String biography) {
        Author author = new Author(name, surname, country, biography);
        return authorRepository.save(author);
    }

    @Override
    public Author edit(Long id, String name, String surname, String country, String biography) {
        Author existingAuthor = findById(id);

        existingAuthor.setName(name);
        existingAuthor.setSurname(surname);
        existingAuthor.setCountry(country);
        existingAuthor.setBiography(biography);

        return authorRepository.save(existingAuthor);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}

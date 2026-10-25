package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryAuthorRepository implements AuthorRepository {
    @Override
    public List<Author> findAll() {
        return DataHolder.authors;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return DataHolder.authors.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    @Override
    public Author save(Author author) {
        Author existingAuthor = findById(author.getId()).orElse(null);

        if(existingAuthor != null){
            existingAuthor.setName(author.getName());
            existingAuthor.setSurname(author.getSurname());
            existingAuthor.setBiography(author.getBiography());
            existingAuthor.setCountry(author.getCountry());
            return existingAuthor;
        }

        DataHolder.authors.add(author);
        return author;
    }

    @Override
    public void deleteById(Long id) {
        DataHolder.authors.removeIf(a -> a.getId().equals(id));
    }
}

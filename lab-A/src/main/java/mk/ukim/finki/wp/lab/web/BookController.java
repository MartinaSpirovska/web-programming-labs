package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getBooksPage(Model model,
                            @RequestParam(required = false, defaultValue = "") String title,
                            @RequestParam(required = false, defaultValue = "0.0") Double averageRating){
        model.addAttribute("books", bookService.searchBooks(title, averageRating));
        return "listBooks";
    }

    @GetMapping("/add")
    public String getAddNewBookForm(Model model){
        model.addAttribute("book", null);
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @GetMapping("/edit/{id}")
    public String getEditBookForm(@PathVariable Long id,
                                  Model model){
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId){
        bookService.save(title, genre, averageRating, authorService.findById(authorId));
        return "redirect:/books";
    }

    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId){
        bookService.update(bookId, title, genre, averageRating, authorService.findById(authorId));
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteForm(@PathVariable Long id,
                                Model model){
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("bookId", id);
        return "delete-form";
    }
}

package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String listBooks(Model model,
                            @RequestParam(required = false, defaultValue = "") String title,
                            @RequestParam(required = false, defaultValue = "0.0") Double averageRating){
        model.addAttribute("books", bookService.searchBooks(title, averageRating));
        return "listBooks";
    }
}

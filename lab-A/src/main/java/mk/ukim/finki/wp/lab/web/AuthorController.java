package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String listAll(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "listAuthors";
    }

    @GetMapping("/add")
    public String getAddAuthorForm(Model model){
        model.addAttribute("author", null);
        return "author-form";
    }

    @PostMapping("/add")
    public String addAuthor(@RequestParam String name,
                            @RequestParam String surname,
                            @RequestParam String country,
                            @RequestParam String biography){
        authorService.add(name, surname, country, biography);
        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteForm(@PathVariable Long id,
                                Model model){
        model.addAttribute("author", authorService.findById(id));
        return "delete-author";
    }

    @PostMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id){
        authorService.deleteById(id);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String getEditAuthorForm(@PathVariable Long id,
                                    Model model){
        model.addAttribute("author", authorService.findById(id));
        return "author-form";
    }

    @PostMapping("/edit/{id}")
    public String editAuthor(@PathVariable Long id,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String country,
                             @RequestParam String biography){
        authorService.edit(id, name, surname, country, biography);
        return "redirect:/authors";
    }
}

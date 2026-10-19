package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/chefs")
public class ChefController {
    private final ChefService chefService;

    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    @GetMapping
    public String listAllChefs(Model model){
        model.addAttribute("chefs", chefService.listChefs());
        return "listChefs";
    }

    @PostMapping("/chefDetails")
    private String getChefDetails(Model model,
                                  @RequestParam String dishId,
                                  @RequestParam Long chefId){
        Chef chef = chefService.addDishToChef(chefId, dishId);
        model.addAttribute("chef", chef);
        return "chefDetails";
    }
}

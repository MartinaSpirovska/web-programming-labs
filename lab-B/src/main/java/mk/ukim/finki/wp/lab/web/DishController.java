package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dish")
public class DishController {
    private final DishService dishService;
    private final ChefService chefService;

    public DishController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @PostMapping
    public String addDishToChef(Model model, @RequestParam Long chefId){
        model.addAttribute("chef", chefService.findById(chefId));
        model.addAttribute("dishes", dishService.listDishes());
        return "dishesList";
    }
}

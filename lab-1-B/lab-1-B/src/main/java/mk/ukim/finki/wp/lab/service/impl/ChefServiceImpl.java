package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.model.exceptions.ChefWithIdDoesntExistException;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefServiceImpl implements ChefService {
    private final ChefRepository chefRepository;
    private final DishService dishService;

    public ChefServiceImpl(ChefRepository chefRepository, DishService dishService) {
        this.chefRepository = chefRepository;
        this.dishService = dishService;
    }

    @Override
    public List<Chef> listChefs() {
        return chefRepository.findAll();
    }

    @Override
    public Chef findById(Long id) {
        return chefRepository.findById(id).orElseThrow(() -> new ChefWithIdDoesntExistException(id));
    }

    @Override
    public Chef addDishToChef(Long chefId, String dishId) {
        Chef chef = findById(chefId);
        Dish dish = dishService.findByDishId(dishId);

        if(!chef.getDishes().contains(dish)){
            chef.getDishes().add(dish);
        }

        return chefRepository.save(chef);
    }
}

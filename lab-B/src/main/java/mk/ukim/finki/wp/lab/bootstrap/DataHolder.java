package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct
    public void init(){
        chefs = new ArrayList<>();
        dishes = new ArrayList<>();

        Dish dish1 = new Dish("dish1", "Pizza", "Italian", 120);
        Dish dish2 = new Dish("dish2", "Lasagna", "Italian", 240);
        Dish dish3 = new Dish("dish3", "Baked Beans", "Macedonian", 65);
        Dish dish4 = new Dish("dish4", "Blueberry Pie", "American", 150);
        Dish dish5 = new Dish("dish5", "Sushi", "Japanese", 140);

        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);
        dishes.add(dish4);
        dishes.add(dish5);

        Chef chef1 = new Chef(1L, "Martina", "Spirovska", "Excellent chef");
        Chef chef2 = new Chef(2L, "Sreten", "Glavincheski", "Amazing chef");
        Chef chef3 = new Chef(3L, "Ivan", "Spirovski", "Spectacular chef");
        Chef chef4 = new Chef(4L, "Vlado", "Spirovski", "Brilliant chef");
        Chef chef5 = new Chef(5L, "Biljana", "Spirovska", "Fantastic chef");

        chefs.add(chef1);
        chefs.add(chef2);
        chefs.add(chef3);
        chefs.add(chef4);
        chefs.add(chef5);
    }
}

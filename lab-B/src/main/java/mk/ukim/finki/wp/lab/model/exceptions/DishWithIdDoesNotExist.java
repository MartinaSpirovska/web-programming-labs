package mk.ukim.finki.wp.lab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DishWithIdDoesNotExist extends RuntimeException{
    public DishWithIdDoesNotExist(String dishId){
        super(String.format("Dish with id %s does not exist!", dishId));
    }
}

package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryChefRepository implements ChefRepository {
    @Override
    public List<Chef> findAll() {
        return DataHolder.chefs;
    }

    @Override
    public Optional<Chef> findById(Long id) {
        return DataHolder.chefs.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public Chef save(Chef chef) {
        Chef existingChef = findById(chef.getId()).orElse(null);

        if(existingChef != null) {
            existingChef.setFirstName(chef.getFirstName());
            existingChef.setLastName(chef.getLastName());
            existingChef.setBio(chef.getBio());
            existingChef.setDishes(chef.getDishes());

            return existingChef;
        }

        DataHolder.chefs.add(chef);
        return chef;
    }
}

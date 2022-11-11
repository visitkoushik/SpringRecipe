package koushik.recipies.recipies.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import koushik.recipies.recipies.domain.Recipe;

public interface RecipieRepository extends CrudRepository<Recipe,Long>{
    Set<Recipe> findAll();
    Recipe save(Recipe recipe);
}

package koushik.recipies.recipies.repositories;

 

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import koushik.recipies.recipies.domain.Category;
public interface CategoryRepository extends CrudRepository<Category,Long>{
    
    Optional<Category> findByCategoryName(String categoryName);
}

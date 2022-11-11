package koushik.recipies.recipies.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import koushik.recipies.recipies.domain.UnitOfMessure;

public interface UnitOfMessureRepository extends CrudRepository<UnitOfMessure,Long>{
    Optional<UnitOfMessure> findByDescription(String description);
}

package koushik.recipies.recipies.bootstrap;


import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import koushik.recipies.recipies.domain.Category;
import koushik.recipies.recipies.domain.Difficulty;
import koushik.recipies.recipies.domain.Ingrediant;
import koushik.recipies.recipies.domain.Notes;
import koushik.recipies.recipies.domain.Recipe;
import koushik.recipies.recipies.repositories.CategoryRepository;
import koushik.recipies.recipies.repositories.RecipieRepository;
import koushik.recipies.recipies.repositories.UnitOfMessureRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner{

    // private final RecipeService recipeService;
    private final CategoryRepository categoryRepository;
    private final UnitOfMessureRepository unitOfMessureRepository;
    private final RecipieRepository recipieRepository;

 

    public DataLoader(
    CategoryRepository categoryRepository, 
    UnitOfMessureRepository unitOfMessureRepository,
    RecipieRepository recipieRepository) {
        // this.recipeService = recipeService;
        this.categoryRepository = categoryRepository;
        this.unitOfMessureRepository = unitOfMessureRepository;
        this.recipieRepository = recipieRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub


        Category category =  this.categoryRepository.findByCategoryName("Snacks").get();
    
        Ingrediant ingrediant1 = new Ingrediant();
        ingrediant1.setDescription("Chiken");
        ingrediant1.setAmount(BigDecimal.valueOf(230));
        ingrediant1.setUnitOfMessure(this.unitOfMessureRepository.findByDescription("Ounce").get());
        Ingrediant ingrediant2 = new Ingrediant();
        ingrediant2.setDescription("Basan");
        ingrediant2.setAmount(BigDecimal.valueOf(100));
        ingrediant2.setUnitOfMessure(this.unitOfMessureRepository.findByDescription("Ounce").get());
        Ingrediant ingrediant3 = new Ingrediant();
        ingrediant3.setDescription("Salt");
        ingrediant3.setAmount(BigDecimal.valueOf(2));
        ingrediant3.setUnitOfMessure(this.unitOfMessureRepository.findByDescription("TeaSpoon").get());
        log.debug("Ingrediant created");

        Recipe recipe = new Recipe();
        recipe.setCookTime(4);
        recipe.getCategories().add(category);
        recipe.setName("Chiken nugget");
        recipe.setDescription("Chiken nugget");
        recipe.setDirection("Fried the chiken with coating");     
        recipe.setDifficulty(Difficulty.HARD);

        recipe.addIngrediants(ingrediant1);
        recipe.addIngrediants(ingrediant2);
        recipe.addIngrediants(ingrediant3);

        Notes n =new Notes();
        n.setNotes("Don't Fri to much");
        
        recipe.setNotes(n);
        recipe.setPrepTime(20);
        recipe.setServeTime(5);
      
        // ingrediant1.setRecipe(recipe);
        // ingrediant2.setRecipe(recipe);
        // ingrediant3.setRecipe(recipe);
        // category.getRecipies().add(recipe);

        
        this.recipieRepository.save(recipe);
        
       
    }
    
}

package koushik.recipies.recipies.controler;

import java.lang.StackWalker.Option;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import koushik.recipies.recipies.domain.Category;
import koushik.recipies.recipies.domain.Recipe;
import koushik.recipies.recipies.domain.UnitOfMessure;
import koushik.recipies.recipies.repositories.CategoryRepository;
import koushik.recipies.recipies.repositories.RecipieRepository;
import koushik.recipies.recipies.repositories.UnitOfMessureRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexControler {
    
 
    private final RecipieRepository recipieRepository;


    public IndexControler(RecipieRepository recipieRepository) {
        this.recipieRepository = recipieRepository;
    }


 
    @RequestMapping({"","index","index.html"})
    public String getIndexPage(Model model){
        // Optional<Category> categoryOptional = this.categoryRepository.findByCategoryName("Snacks");
        // Optional<UnitOfMessure> uomOptional = this.unitOfMessureRepository.findByDescription("TableSpoon");

        Set<Recipe> recipies = this.recipieRepository.findAll();

        model.addAttribute("recpies", recipies);
        log.debug("Test Project lombok");
        return "index";
    }
}

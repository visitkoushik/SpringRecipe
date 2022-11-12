package koushik.recipies.recipies.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(exclude = {"recipies"})
@Entity
public class Category  extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;
    private String description;

    @ManyToMany(mappedBy = "categories")
    // @JoinTable(name="recipe_category",
    // joinColumns = @JoinColumn(name="recipe_id"),
    // inverseJoinColumns = @JoinColumn(name="category_id"))
    private Set<Recipe> recipies= new HashSet<>();
    
}

package koushik.recipies.recipies.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set; 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

 

@Data
@Entity
public class Recipe  extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer serveTime;
    private String url;
    private String direction;

    @ManyToMany
    //(mappedBy = "recipies")
    @JoinTable(name="recipe_category",
    joinColumns = @JoinColumn(name="recipe_id"),
    inverseJoinColumns = @JoinColumn(name="category_id"))
    private Set<Category> categories = new HashSet<>();

    @Lob
    private Byte[] image;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingrediant> ingrediants = new HashSet<>();


    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

 

    public void setNotes(Notes notes) {
        notes.setRecipe(this);
        this.notes = notes;

    }
 

    public List<String> getCategoriesByName() {
        List<String> l= new ArrayList<String>(this.categories.size());
        this.categories.forEach(c->{
            l.add(c.getCategoryName());
        });

        return l;
    }

     
    public void addIngrediants(Ingrediant ingrediant) {
        ingrediant.setRecipe(this);
        this.ingrediants.add(ingrediant);
    }
 

}

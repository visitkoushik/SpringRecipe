package koushik.recipies.recipies.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Recipe {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer serveTime;
    private String url;
    private String direction;

    @Lob
    private Byte[] image;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingrediant> ingrediants = new HashSet<>();


    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return this.prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return this.cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServeTime() {
        return this.serveTime;
    }

    public void setServeTime(Integer serveTime) {
        this.serveTime = serveTime;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Byte[] getImage() {
        return this.image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return this.notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Set<Ingrediant> getIngrediants() {
        return this.ingrediants;
    }

 


}

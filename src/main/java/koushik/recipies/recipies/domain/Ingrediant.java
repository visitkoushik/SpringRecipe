package koushik.recipies.recipies.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ingrediant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private UnitOfMessure unitOfMessure;

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

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }


    public UnitOfMessure getUnitOfMessure() {
        return this.unitOfMessure;
    }

    public void setUnitOfMessure(UnitOfMessure unitOfMessure) {
        this.unitOfMessure = unitOfMessure;
    }


}

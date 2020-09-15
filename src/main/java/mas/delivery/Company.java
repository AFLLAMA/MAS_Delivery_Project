package mas.delivery;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "company")
public class Company {
    private static int quantity;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "catalogue_id")
    private CatalogueOfCompanies catalogue;


    @JsonManagedReference
    @OneToMany(mappedBy = "company")
//    @JoinColumn(name = "company_id")
    private Set<Product> products = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "best")
    private Set<Product> best = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "company")
    private Set<Comment> comments = new TreeSet<Comment>(new CommentComparator());

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    public Company() {
    }

    public Company(@NotBlank String name, @NotBlank String address) {
        this.name = name;
        this.address = address;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void removeComment(Comment comment){
        comments.remove(comment);
    }

    public static int getQuantity() {
        return quantity;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public CatalogueOfCompanies getCatalogueOfCompanies() {
        return catalogue;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @JsonIgnore
    public void setCatalogueOfCompanies(CatalogueOfCompanies catalogueOfCompanies){
        this.catalogue = catalogueOfCompanies;
    }

    public Set<Product> getBest() {
        return best;
    }

    public void addBest(Product best) {
        if (products.contains(best)&&(products.size()/this.best.size()) < 2) {
            this.best.add(best);
        }
        else
            throw new IllegalArgumentException("best product addition violates constrains");
    }

    public void removeBest(Product best){
        this.best.remove(best);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addProduct(Product product){
        products.add(product);
        product.setCompany(this);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public CatalogueOfCompanies getCatalogue() {
        return catalogue;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return getName();
    }

}

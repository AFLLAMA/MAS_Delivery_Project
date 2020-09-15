package mas.delivery;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "catalogue_of_companies")
public class CatalogueOfCompanies {
    public static CatalogueOfCompanies catalogues;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catalogueId;

    @NotBlank
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "catalogue")
    private Set<Company> companies = new HashSet<>();

    public CatalogueOfCompanies(@NotBlank String name) {
        this.name = name;
    }

    public CatalogueOfCompanies() {
    }

    public static CatalogueOfCompanies getCatalogues() {
        return catalogues;
    }

    public Long getCatalogueId() {
        return catalogueId;
    }

    public String getName() {
        return name;
    }
    public void addCompany(Company company){
        if (company==null)
            throw new IllegalArgumentException("company can not be null");
        if (!companies.contains(company) && (company.getCatalogueOfCompanies() == this || company.getCatalogueOfCompanies() == null)) {
//            companies.add(company);
            company.setCatalogueOfCompanies(this);
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void removeCompany(Company company){
        companies.remove(company);
    }
}

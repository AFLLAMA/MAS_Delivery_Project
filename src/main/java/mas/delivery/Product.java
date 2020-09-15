package mas.delivery;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;

import java.util.List;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank
    private String name;

    private double cost;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "companyid")
    private Company company;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "company_best_id", referencedColumnName = "companyid")
    private Company best;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_delivery_order",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "delivery_order_id")}
    )
    private List<DeliveryOrder> delivery_orders = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryid")
    private Category category;

    public Product(@NotBlank String name, Double cost) {
        this.name = name;
        this.cost = cost;
    }

    public void addOrder(DeliveryOrder o){
        delivery_orders.add(o);
    }

    public Product() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public Company getCompany() {
        return company;
    }

    public Long getProductId() {
        return productId;
    }

    public List<DeliveryOrder> getDelivery_orders() {
        return delivery_orders;
    }

    @Override
    public String toString() {
        return name;
    }
}

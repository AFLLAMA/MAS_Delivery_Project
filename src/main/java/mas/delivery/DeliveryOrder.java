package mas.delivery;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance
@Table(name="delivery_order")
public class DeliveryOrder {
    private static List<DeliveryOrder> orders = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryOrderId;
    private double price;

    private String status = "Pending payment";

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @Size(min = 0, max = 10)
    @ManyToMany(mappedBy = "delivery_orders", fetch = FetchType.EAGER )
    private List<Product> products = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "review_id")
    private Review review;

    public DeliveryOrder() {}

    public void setCustomer(User user){
        customer = user;
    }

    public static List<DeliveryOrder> getOrders() {
        return orders;
    }

    public void addProduct(Product product){
        products.add(product);
//        System.out.println("HERE");
        product.addOrder(this);
    }

    public Long getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public User getCustomer() {
        return customer;
    }

    public Courier getCourier() {
        return courier;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateCost(){
        double sum = products.stream().mapToDouble(f -> f.getCost()).sum();
        price = sum;
        return sum;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public void setDeliveryOrderId(Long deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void statusToPayed() {
        this.status = "Payed";
    }
    public void statusToDelivered() {
        this.status = "Delivered";
    }
    public void statusToCanceled() {
        this.status = "Canceled";
    }
    public void statusToRefunded() {
        this.status = "Refunded";
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "deliveryOrderId=" + deliveryOrderId +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                ", courier=" + courier +
                ", products=" + products +
                ", review=" + review +
                '}';
    }
}

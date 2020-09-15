package mas.delivery;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "Courier")
public class Courier extends User {

    @NotBlank
    private String phoneNumber;


    public Courier(@NotBlank String username, @NotBlank String password, @NotBlank String name, @NotBlank String surname, @NotBlank String  phoneNumber, @NotBlank LocalDate hire) {
        super(username,password,name,surname,hire);
        this.setCustomerTypeToNone();
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(mappedBy = "courier")
    private Set<DeliveryOrder> deliveryOrders = new HashSet<>();

    public Courier() {
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Set<DeliveryOrder> getDeliveryOrders() {
        return deliveryOrders;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", # of deliveryOrders=" + deliveryOrders.size() +
                '}';
    }
}

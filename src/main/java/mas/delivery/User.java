package mas.delivery;

import mas.delivery.descriptors.EnumSetType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance
@Table(name = "user")
@TypeDef(name = "enum-set",typeClass = mas.delivery.descriptors.EnumSetType.class)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private String address;

    private String creditCard;

    private LocalDate dateOfHiring;

    private LocalDate validUntil;

    @Column(length = 10)
    @Type(type = "enum-set", parameters = {@org.hibernate.annotations.Parameter(name = "enumClass", value = "mas.delivery.UserType")})
    private EnumSet<UserType> type = EnumSet.noneOf(UserType.class);

    @Column(length = 10)
    @Type(type = "enum-set", parameters = {@org.hibernate.annotations.Parameter(name = "enumClass", value = "mas.delivery.CustomerType")})
    private EnumSet<CustomerType> customerType = EnumSet.noneOf(CustomerType.class);

    @OneToMany(mappedBy = "customer")
    private Set<DeliveryOrder> deliveryOrders = new HashSet<>();

    public User(){
        super();
    }

    //new customer
    public User(@NotBlank String username, @NotBlank String password, @NotBlank String name, @NotBlank String surname, @NotBlank String address){
        super();
        this.address = address;
        this.username = username;
        setPassword(password);
        this.name = name;
        this.surname = surname;
        type.add(UserType.CUSTOMER);
        customerType.add(CustomerType.BASIC);

    }
    //new employee
    public User(@NotBlank String username, @NotBlank String password, @NotBlank String name, @NotBlank String surname, @NotBlank LocalDate hireDate){
        super();
        this.dateOfHiring =hireDate;
        this.username = username;
        setPassword(password);
        this.name = name;
        this.surname = surname;
        type.add(UserType.EMPLOYEE);

    }

    //new employee
    public User(@NotBlank String username, @NotBlank String password, @NotBlank String name, @NotBlank String surname, @NotBlank LocalDate hireDate, boolean isCustomer, String address){
        super();
        this.dateOfHiring =hireDate;
        this.username = username;
        setPassword(password);
        this.name = name;
        this.surname = surname;
        type.add(UserType.EMPLOYEE);
        if (isCustomer) {
            this.address = address;
            type.add(UserType.CUSTOMER);
            customerType.add(CustomerType.BASIC);
        }
    }

    public void upgrade(LocalDate validUntil){
        if (type.contains(UserType.CUSTOMER)) {
            customerType.add(CustomerType.PREMIUM);
            this.validUntil = validUntil;
        }
    }


    public void setCustomerTypeToNone(){
        customerType = null;
    }

    public void degrade(){
        customerType.remove(CustomerType.PREMIUM);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        if (username!= null && username.equals(password))
            throw new IllegalArgumentException("username can not be like passport or you have no username yet");
        if (password.length()<8)
            throw new IllegalArgumentException("password should be longer than 8");
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public void setDateOfHiring(LocalDate dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public LocalDate getDateOfHiring() {
        return dateOfHiring;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public EnumSet<UserType> getType() {
        return type;
    }

    public EnumSet<CustomerType> getCustomerType() {
        return customerType;
    }

    public Set<DeliveryOrder> getDeliveryOrders() {
        return deliveryOrders;
    }

    public void makeOrder(){


    }
}

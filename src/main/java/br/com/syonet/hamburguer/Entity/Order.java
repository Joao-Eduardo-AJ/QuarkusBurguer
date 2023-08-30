package br.com.syonet.hamburguer.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "Order")
@Table(name = "table_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_burguer_shop", referencedColumnName = "id", nullable = false)
    private BurguerShop burguerShop;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @Column(name = "description")
    private String description;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "status")
    private Status status;

    @ManyToMany(mappedBy = "order")
    private List<Food> foods;

    @ManyToMany(mappedBy = "order")
    private List<Beverage> beverages;

    public Order() {
    }

    public Order(BurguerShop burguerShop, Customer customer, List<Food> foods, List<Beverage> beverages,
            String description) {
        this.burguerShop = burguerShop;
        this.customer = customer;
        this.description = description;
        beverages.forEach(beverage -> {
            this.totalPrice += beverage.getPrice();
        });
        foods.forEach(food -> {
            this.totalPrice += food.getPrice();
        });
    }

    public Integer getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public String getDescription() {
        return description;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Status getStatus() {
        return status;
    }
}

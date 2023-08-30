package br.com.syonet.hamburguer.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "BurguerShop")
@Table(name = "table_burguer_shop")
public class BurguerShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "burguerShop", fetch = FetchType.EAGER)
    private List<Food> foods;

    @OneToMany(mappedBy = "burguerShop", fetch = FetchType.EAGER)
    private List<Beverage> beverages;

    @OneToMany(mappedBy = "burguerShop", fetch = FetchType.EAGER)
    private List<Customer> customers;

    @OneToMany(mappedBy = "burguerShop", fetch = FetchType.EAGER)
    private List<Order> orders;

    public BurguerShop() {
    }

    public BurguerShop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Order> getOrders() {
        return orders;
    }
}

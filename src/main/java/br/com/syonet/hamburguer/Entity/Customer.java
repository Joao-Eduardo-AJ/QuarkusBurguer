package br.com.syonet.hamburguer.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Customer")
@Table(name = "table_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_burguer_shop", referencedColumnName = "id", nullable = false)
    private BurguerShop burguerShop;

    @Column(name = "name")
    private String name;

    @Column(name = "id_card")
    private Integer idCard;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer() {
    }

    public Customer(BurguerShop burguerShop, String name, List<Order> orders) {
        this.burguerShop = burguerShop;
        this.name = name;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }
}

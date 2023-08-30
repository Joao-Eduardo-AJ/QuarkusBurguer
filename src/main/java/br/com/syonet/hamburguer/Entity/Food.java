package br.com.syonet.hamburguer.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "Food")
@Table(name = "table_food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_burguer_shop", referencedColumnName = "id", nullable = false)
    private BurguerShop burguerShop;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id", nullable = false)
    private Order order;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    public Food() {
    }

    public Food(BurguerShop burguerShop, String name, String description, double price) {
        this.burguerShop = burguerShop;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}

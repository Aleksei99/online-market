package by.work.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name="products")
public class Product extends BaseEntity{

    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column (name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @Column(name = "description")
    private String description;

    public Product(String brand,String name,Double price,Subcategory subcategory,User seller,String description) {
        this.brand=brand;
        this.name=name;
        this.price=price;
        this.subcategory=subcategory;
        this.seller=seller;
        this.description=description;
    }

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;
}

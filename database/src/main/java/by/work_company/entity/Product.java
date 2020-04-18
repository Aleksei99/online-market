package by.work_company.entity;

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

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "name", nullable = false)
    private String name;

    @Column (name = "price", nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "subcategory_id", nullable = false)
    private Subcategory subcategory;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User seller;

    @Column(name = "destription")
    private String description;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;
}

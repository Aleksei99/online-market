package by.work.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "basket")
public class Basket extends BaseEntity {

    @Column(name = "order_id")
    private Long orderID;

    @Column(name = "product_id")
    private Long productID;

    @Column(name = "count")
    private int count;

    public Basket(Long orderID, Long productID,int count) {
        this.orderID=orderID;
        this.productID=productID;
        this.count=count;
    }
}

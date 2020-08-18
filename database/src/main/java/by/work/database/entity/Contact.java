package by.work.database.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "contacts")
public class Contact extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "telephone", unique = true, nullable = false)
    private String telephone;

    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "house", column = @Column(name = "home_house")),
            @AttributeOverride(name = "number", column = @Column(name = "home_number"))
    })
    private Address homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "other_city")),
            @AttributeOverride(name = "street", column = @Column(name = "other_street")),
            @AttributeOverride(name = "house", column = @Column(name = "other_house")),
            @AttributeOverride(name = "number", column = @Column(name = "other_number"))
    })
    private Address otherAddress;

    @Column(name = "email")
    private String email;

    @Column(name = "another_address")
    private Boolean anotherAddress;
}

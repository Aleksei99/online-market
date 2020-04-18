package by.work_company.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name="contacts")
public class Contact {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "telephone", unique = true)
    private String telephone;

    @Column(name = "address")
    private String address;

    @Column(name = "other_address")
    private String otherAddress;

    @Column(name = "email", unique = true)
    private String email;
}

package by.work.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor

@Entity
@Table(name = "users", schema = "online_market")
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Enumerated(EnumType.STRING)
    private Role role;


    public User(String name, String surname, Role role) {
        this.name = name;
        this.surname = surname;
        this.role = role;
    }
}

package by.work.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
@NoArgsConstructor

@Entity
@Table(name = "users", schema = "online_market")
public class User extends BaseEntity {

    @Column(name = "name")
    @Size(min = 3, max = 16, message = "errors.user.name")
    private String name;

    @Column(name = "surname")
    @Size(min = 3, max = 24, message = "errors.user.surname")
    private String surname;

    @Enumerated(EnumType.STRING)
    private Role role;


    public User(String name, String surname, Role role) {
        this.name = name;
        this.surname = surname;
        this.role = role;
    }
}

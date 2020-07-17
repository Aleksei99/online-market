package by.work.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
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

    @Column(name = "login", unique = true)
    private String login;

    /**
     * ^                 # start-of-string
     * (?=.*[0-9])       # a digit must occur at least once
     * (?=.*[a-z])       # a lower case letter must occur at least once
     * (?=.*[A-Z])       # an upper case letter must occur at least once
     * (?=.*[@#$%^&+=])  # a special character must occur at least once
     * (?=\S+$)          # no whitespace allowed in the entire string
     * .{8,}             # anything, at least eight places though
     * $                 # end-of-string
     */
    @Column(name = "password")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", message = "errors.user.password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    public User(String name, String surname,String login,String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.login=login;
        this.password=password;
        this.role = role;
    }
}

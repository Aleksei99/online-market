package by.work.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor


@Entity
@Table(name="personal_info")
public class PersonalInfo extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    public PersonalInfo(User user,String login,String password) {
        this.user=user;
        this.login=login;
        this.password=password;
    }
}

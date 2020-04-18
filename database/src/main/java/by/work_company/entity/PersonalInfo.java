package by.work_company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name="personal_info")
public class PersonalInfo {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

}

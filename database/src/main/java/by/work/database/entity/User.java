package by.work.database.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="users", schema = "online_market")
@ToString
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    private PersonalInfo personalInfo;
}

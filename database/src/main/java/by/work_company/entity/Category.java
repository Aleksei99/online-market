package by.work_company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name="categories")
public class Category extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
}

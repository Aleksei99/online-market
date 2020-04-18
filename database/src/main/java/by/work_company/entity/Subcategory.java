package by.work_company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name="subcategories")
public class Subcategory extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private int categoryId;

}
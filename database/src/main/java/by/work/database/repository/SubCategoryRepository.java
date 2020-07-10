package by.work.database.repository;

import by.work.database.entity.Subcategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubCategoryRepository extends CrudRepository<Subcategory,Long> {
    List<Subcategory> findAllByCategory_Id(Long id);
}

package by.work.database.repository;

import by.work.database.entity.Subcategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SubCategoryRepository extends CrudRepository<Subcategory, Long> {
    List<Subcategory> findAllByCategoryId(Long id);

    Subcategory findById(Long id);
}

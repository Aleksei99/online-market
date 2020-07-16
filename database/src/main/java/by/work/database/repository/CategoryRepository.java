package by.work.database.repository;

import by.work.database.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findById(Long id);
}

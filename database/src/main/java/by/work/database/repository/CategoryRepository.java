package by.work.database.repository;

import by.work.database.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
        Category findById(Long id);
}

package by.work.database.repository;

import by.work.database.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findProductsBySubcategoryId(Long id);
}

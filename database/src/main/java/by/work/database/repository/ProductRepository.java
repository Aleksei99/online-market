package by.work.database.repository;

import by.work.database.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findProductsBySubcategoryId(Long id);
    Product findProductById(Long id);
}

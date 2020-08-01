package by.work.service;

import by.work.database.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    List<Product> findProducts(Long id);

    List<Product> findAll();

    Product findProduct(Long id);
}

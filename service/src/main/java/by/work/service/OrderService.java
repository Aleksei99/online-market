package by.work.service;

import by.work.database.entity.Order;
import by.work.database.entity.Product;
import by.work.service.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.Set;

public interface OrderService {

    Order save(ProductDTO products);
    BigDecimal getTotalAmount(Set<Product> products);
    void update(Order order,Double totalAmount);
}

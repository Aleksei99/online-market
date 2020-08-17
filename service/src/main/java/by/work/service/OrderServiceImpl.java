package by.work.service;

import by.work.database.entity.Order;
import by.work.database.entity.Product;
import by.work.database.entity.User;
import by.work.database.repository.OrderRepository;
import by.work.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public Order save(ProductDTO products) {
        User user = userService.getCurrentUser();
        Set<Product> productsSet = new HashSet<>();
        Order order= new Order();
        for(Long productID: products.getProductsID()){
            productsSet.add(productService.findProduct(productID));
        }
        java.sql.Timestamp timeOrder = new java.sql.Timestamp(new java.util.Date().getTime());
        order.setTimeOrder(timeOrder);
        order.setUser(user);
        order.setProducts(productsSet);
        return orderRepository.save(order);
    }

    @Override
    public BigDecimal getTotalAmount(Set<Product> products) {
        return null;
    }

    @Override
    public void update(Order order, BigDecimal totalAmount) {
        order.setTotalAmount(totalAmount);
        orderRepository.save(order);
    }
}

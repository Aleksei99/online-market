package by.work.service;

import by.work.database.entity.*;
import by.work.database.repository.CategoryRepository;
import by.work.database.repository.ProductRepository;
import by.work.database.repository.SubCategoryRepository;
import by.work.database.repository.UserRepository;
import by.work.service.config.ServiceConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
@ComponentScan(basePackages = {"by.work", "by.work.service"})
@Transactional
public class ProductServiceTest {
    private static final String BRAND, NAME, DESCRIPTION;
    private static final double PRICE;

    static {
        BRAND = "APPLE";
        NAME = "MAC";
        DESCRIPTION = "APPLABLE";
        PRICE = 999.99;
    }

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Before
    public void setUp() throws Exception {
        User user = new User("Eva", "Green", Role.SELLER);
        userRepository.save(user);
        List<Subcategory> subcategories = new ArrayList<>();
        Category category = new Category("Computer", subcategories);
        categoryRepository.save(category);
        Subcategory sub = new Subcategory(category, "Sub");
        subCategoryRepository.save(sub);
        Product product = new Product(BRAND, NAME, PRICE, sub, user, DESCRIPTION);
        productRepository.save(product);
    }

    @Test
    public void saveTest() {
        Product product = new Product("BMW", "M8", 50000.99, new Subcategory(), new User(), "Car");
        product.setId(2L);
        productService.save(product);
    }

    @Test
    public void findProductsTest() {
        List<Product> products = productService.findProducts(1L);

        Assert.assertNotNull(products);
    }
}

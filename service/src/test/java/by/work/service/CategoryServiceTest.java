package by.work.service;

import by.work.database.entity.Category;
import by.work.database.entity.Subcategory;
import by.work.database.repository.CategoryRepository;
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

import java.util.List;

/**
 * FIXME NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
@ComponentScan(basePackages = {"by.work", "by.work.service"})
@Transactional
public class CategoryServiceTest {

    private static final String NAME = "Car";
    private List<Subcategory> list;

    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
        Category category = new Category(NAME, list);
        categoryRepository.save(category);
    }

    @Test
    public void addCategoryTest() {
        Category category = new Category("Computer", list);
        categoryService.addCategory(category);
    }

    @Test
    public void getCategoryByIdTest() {
        Long id = categoryService.getAllCategories().iterator().next().getId();
        Category category = categoryService.getCategory(id);

        Assert.assertEquals(NAME, category.getName());
    }

}

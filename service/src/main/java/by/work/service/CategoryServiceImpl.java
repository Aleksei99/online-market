package by.work.service;

import by.work.database.entity.Category;
import by.work.database.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Iterable<Category> getAll() {
        return categoryRepository.findAll();
    }
}

package by.work.service;

import by.work.database.entity.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);

    Category getCategory(Long id);

    List<Category> getAllCategories();
}

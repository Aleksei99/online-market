package by.work.service;

import by.work.database.entity.Category;

public interface CategoryService {
    void addCategory(Category category);
    Category getCategory(Long id);
    Iterable<Category> getAll();
}

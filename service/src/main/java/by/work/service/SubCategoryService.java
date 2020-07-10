package by.work.service;

import by.work.database.entity.Subcategory;

public interface SubCategoryService {
    void addSubCategory(Subcategory subcategory);
    Iterable<Subcategory> getAll();
}

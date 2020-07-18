package by.work.service;

import by.work.database.entity.Subcategory;

import java.util.List;

public interface SubCategoryService {
    void addSubCategory(Subcategory subcategory);

    List<Subcategory> getAllSubCategories();

    List<Subcategory> getAllByCategoryID(Long id);

    Subcategory getSubCategory(Long id);
}

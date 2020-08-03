package by.work.service;

import by.work.database.entity.Subcategory;
import by.work.database.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public void addSubCategory(Subcategory subcategory) {
        subCategoryRepository.save(subcategory);
    }

    @Override
    public void deleteSubCategory(Long id) {
        subCategoryRepository.delete(id);
    }

    @Override
    public List<Subcategory> getAllSubCategories() {
        Iterable<Subcategory> all = subCategoryRepository.findAll();
        List<Subcategory> subcategories = new ArrayList<>();
        for (Subcategory s:all) {
            subcategories.add(s);
        }
        return subcategories;
    }

    @Override
    public List<Subcategory> getAllByCategoryID(Long id) {
        return subCategoryRepository.findAllByCategoryId(id);
    }

    @Override
    public Subcategory getSubCategory(Long id) {
        return subCategoryRepository.findById(id);
    }
}

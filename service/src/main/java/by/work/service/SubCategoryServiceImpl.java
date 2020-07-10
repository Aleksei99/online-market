package by.work.service;

import by.work.database.entity.Subcategory;
import by.work.database.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService{

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
    public Iterable<Subcategory> getAll() {
        return subCategoryRepository.findAll();
    }
}
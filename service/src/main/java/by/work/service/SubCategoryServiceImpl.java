package by.work.service;

import by.work.database.entity.Subcategory;
import by.work.database.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public List<Subcategory> getAllByCategoryID(Long id) {
        return subCategoryRepository.findAllByCategory_Id(id);
    }

    @Override
    public Subcategory getSubCategory(Long id) {
        return subCategoryRepository.findById(id);
    }
}

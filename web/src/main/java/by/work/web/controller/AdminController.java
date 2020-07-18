package by.work.web.controller;

import by.work.database.entity.Category;
import by.work.database.entity.Subcategory;
import by.work.service.CategoryService;
import by.work.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;

    @Autowired
    public AdminController(CategoryService categoryService, SubCategoryService subCategoryService) {
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
    }

    @ModelAttribute("category")
    public Category modelCategory() {
        Category category = new Category();
        return category;
    }

    @ModelAttribute("subcategory")
    public Subcategory modelSubCategory() {
        Subcategory subcategory = new Subcategory();
        return subcategory;
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<Subcategory> subcategories = subCategoryService.getAllSubCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("subcategories", subcategories);
        return "admin";
    }

    @PostMapping("/admin/addCategory")
    public String addCategory(Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin";
    }

    @PostMapping("/admin/addSubCategory")
    public String addSubCategory(Subcategory subcategory, @RequestParam(value = "id", required = false) Long id) {
        subCategoryService.addSubCategory(new Subcategory(categoryService.getCategory(id), subcategory.getName()));
        return "redirect:/admin";
    }


}

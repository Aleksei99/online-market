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
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    @ModelAttribute("category")
    public Category modelCategory(){
        Category category = new Category();
        return category;
    }

    @ModelAttribute("subcategory")
    public Subcategory modelSubCategory(){
        Subcategory subcategory = new Subcategory();
        return subcategory;
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model){
        Iterable<Category> all = categoryService.getAll();
        Iterable<Subcategory> subcategoryIterable = subCategoryService.getAll();
        List<Category> categories = new ArrayList<>();
        List<Subcategory> subcategories = new ArrayList<>();
        for(Category item: all){
            categories.add(item);
        }
        for (Subcategory item: subcategoryIterable){
            subcategories.add(item);
        }
        model.addAttribute("subcategories",subcategories);
        model.addAttribute("categories",categories);
        return "admin";
    }

    @PostMapping("/admin/add")
    public String addCategory(Category category){
        categoryService.addCategory(category);
        return "redirect:/admin";
    }

    @PostMapping("/admin/addSubCategory")
    public String addSubCategory(Subcategory subcategory, @RequestParam(value = "id",required = false) Long id){
        subCategoryService.addSubCategory(new Subcategory(categoryService.getCategory(id),subcategory.getName()));
        return "redirect:/admin";
    }


}

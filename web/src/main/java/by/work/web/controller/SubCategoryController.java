package by.work.web.controller;

import by.work.database.entity.Subcategory;
import by.work.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SubCategoryController {
    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping("/category/{id}")
    public String showPage(@PathVariable("id") Long categoryId, Model model) {

        List<Subcategory> subCategories = subCategoryService.getAllByCategoryID(categoryId);
        model.addAttribute("subCategories", subCategories);
        return "subCategories";
    }
}

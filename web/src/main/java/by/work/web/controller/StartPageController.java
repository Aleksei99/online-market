package by.work.web.controller;

import by.work.database.entity.Category;
import by.work.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StartPageController {

    private final CategoryService categoryService;

    @Autowired
    public StartPageController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String showPage(Model model) {
        Iterable<Category> all = categoryService.getAll();
        List<Category> categories = new ArrayList<>();
        for (Category item : all) {
            categories.add(item);
        }
        model.addAttribute("categories", categories);
        return "startPage";
    }
}

package by.work.web.controller;

import by.work.database.entity.Category;
import by.work.database.entity.User;
import by.work.service.CategoryService;
import by.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CategoryService categoryService;

    private final UserService userService;

    @Autowired
    public HomeController(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        User user = userService.getCurrentUser();
        model.addAttribute("currentUser", user);
        model.addAttribute("categories", categories);
        return "home";
    }
}

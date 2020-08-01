package by.work.web.controller;

import by.work.database.entity.Category;
import by.work.database.entity.Product;
import by.work.database.entity.User;
import by.work.service.CategoryService;
import by.work.service.ProductService;
import by.work.service.UserService;
import by.work.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final UserService userService;

    @ModelAttribute("ListProducts")
    public ProductDTO modelDto(){
        return new ProductDTO();
    }

    @Autowired
    public HomeController(CategoryService categoryService, ProductService productService, UserService userService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<Product> products = productService.findAll();
        User user = userService.getCurrentUser();
        model.addAttribute("modelProducts",products);
        model.addAttribute("currentUser", user);
        model.addAttribute("categories", categories);
        return "home";
    }
}

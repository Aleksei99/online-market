package by.work.web.controller;

import by.work.database.entity.Category;
import by.work.database.entity.Product;
import by.work.database.entity.Subcategory;
import by.work.database.entity.User;
import by.work.service.CategoryService;
import by.work.service.ProductService;
import by.work.service.SubCategoryService;
import by.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SellerController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final SubCategoryService subCategoryService;
    private final UserService userService;

    @Autowired
    public SellerController(CategoryService categoryService, ProductService productService, SubCategoryService subCategoryService, UserService userService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.subCategoryService = subCategoryService;
        this.userService = userService;
    }

    @ModelAttribute("product")
    public Product getProduct() {
        Product product = new Product();
        return product;
    }

    @ModelAttribute("subCategories")
    public List<Subcategory> getSubCategories() {
        List<Subcategory> subcategories = subCategoryService.getAllSubCategories();
        return subcategories;
    }

    @GetMapping("/addProduct")
    public String getPage(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String saveProduct(Product product, @RequestParam(value = "subCategoryID", required = false) Long id) {
        User user = userService.getCurrentUser();
        Subcategory subcategory = subCategoryService.getSubCategory(id);
        productService.save(new Product(product.getBrand(), product.getName(), product.getPrice(), subcategory, user, product.getDescription()));
        return "redirect:/addProduct";
    }
}

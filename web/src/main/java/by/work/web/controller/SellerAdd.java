package by.work.web.controller;

import by.work.database.entity.Product;
import by.work.database.entity.Subcategory;
import by.work.database.entity.User;
import by.work.service.ProductService;
import by.work.service.SubCategoryService;
import by.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SellerAdd {

    private final ProductService productService;
    private final SubCategoryService subCategoryService;
    private final UserService userService;

    @Autowired
    public SellerAdd(ProductService productService, SubCategoryService subCategoryService, UserService userService) {
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
    public String getPage() {
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

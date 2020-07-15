package by.work.web.controller;

import by.work.database.entity.Product;
import by.work.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public String getPage(@PathVariable("id") Long id, Model model) {
        List<Product> products = productService.findProducts(id);
        model.addAttribute("products", products);
        return "products";
    }
}

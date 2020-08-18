package by.work.web.controller;

import by.work.database.entity.Category;
import by.work.database.entity.Order;
import by.work.database.entity.Product;
import by.work.service.CategoryService;
import by.work.service.OrderService;
import by.work.service.ProductService;
import by.work.service.UserService;
import by.work.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductsController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public ProductsController(CategoryService categoryService, ProductService productService, OrderService orderService, UserService userService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @ModelAttribute("ListProducts")
    public ProductDTO products(){
        ProductDTO productsDTO = new ProductDTO();
        return productsDTO;
    }

    @ModelAttribute("order")
    public Order order(){
        Order order = new Order();
        return order;
    }

    @PostMapping("/cart")
    public String toCart(ProductDTO products, HttpSession httpSession){
        Order order = orderService.save(products);
        httpSession.setAttribute("currentOrder",order);
        return "redirect:/cart";
    }

    @GetMapping("/products/{id}")
    public String getPage(@PathVariable("id") Long id, Model model) {
        List<Product> products = productService.findProducts(id);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("modelProducts", products);
        model.addAttribute("categories", categories);
        return "products";
    }
}

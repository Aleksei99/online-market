package by.work.web.controller;

import by.work.database.entity.*;
import by.work.service.CategoryService;
import by.work.service.ContactService;
import by.work.service.OrderService;
import by.work.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class AdminController {

    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;
    private final OrderService orderService;
    private final ContactService contactService;

    @Autowired
    public AdminController(CategoryService categoryService, SubCategoryService subCategoryService, OrderService orderService, ContactService contactService) {
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
        this.orderService = orderService;
        this.contactService = contactService;
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

    @PostMapping("/admin/deleteCategory")
    public String deleteCategory(@RequestParam(value = "id", required = false) Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/addSubCategory")
    public String addSubCategory(Subcategory subcategory, @RequestParam(value = "id", required = false) Long id) {
        subCategoryService.addSubCategory(new Subcategory(categoryService.getCategory(id), subcategory.getName()));
        return "redirect:/admin";
    }

    @PostMapping("/admin/deleteSubCategory")
    public String deleteSubCategory(@RequestParam(value = "id", required = false) Long id) {
        subCategoryService.deleteSubCategory(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/orders")
    public String orders(Model model){
        List<Order> orders = orderService.findOrders();
        model.addAttribute("orders",orders);
        return "orders";
    }

    @GetMapping("/order/{id}")
    public String showDetails(@PathVariable("id") Long orderId, Model model) {
        Order order =  orderService.findById(orderId);
        User user = order.getUser();
        Set<Product> products = order.getProducts();
        Contact contact = contactService.findByUser(user);
        model.addAttribute("products",products);
        model.addAttribute("contact",contact);
        model.addAttribute("order",order);
        return "detailOrder";
    }

}

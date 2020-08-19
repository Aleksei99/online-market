package by.work.web.controller;

import by.work.database.entity.Category;
import by.work.database.entity.Contact;
import by.work.database.entity.Order;
import by.work.service.CategoryService;
import by.work.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderingController {

    private final ContactService contactService;
    private final CategoryService categoryService;

    @Autowired
    public OrderingController(ContactService contactService, CategoryService categoryService) {
        this.contactService = contactService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("order")
    public Order getOrder(HttpSession session) {
        return (Order) session.getAttribute("currentOrder");
    }

    @ModelAttribute("contact")
    public Contact getContact() {
        Contact contact = contactService.findUserContact();
        return contact;
    }

    @GetMapping("/ordering")
    public String getPage(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "ordering";
    }

    @GetMapping("/ordering/confirmed")
    public String getSuccessPage() {
        return "readyOrder";
    }
}

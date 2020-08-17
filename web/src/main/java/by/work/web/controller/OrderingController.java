package by.work.web.controller;

import by.work.database.entity.Contact;
import by.work.database.entity.Order;
import by.work.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class OrderingController {

    private final ContactService contactService;

    @Autowired
    public OrderingController(ContactService contactService) {
        this.contactService = contactService;
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
    public String getPage() {
        return "ordering";
    }
}

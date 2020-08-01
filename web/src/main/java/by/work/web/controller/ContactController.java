package by.work.web.controller;

import by.work.database.entity.Address;
import by.work.database.entity.Category;
import by.work.database.entity.Contact;
import by.work.service.CategoryService;
import by.work.service.ContactService;
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
public class ContactController {

    private final CategoryService categoryService;
    private final ContactService contactService;
    private final UserService userService;

    @Autowired
    public ContactController(CategoryService categoryService, ContactService contactService, UserService userService) {
        this.categoryService = categoryService;
        this.contactService = contactService;
        this.userService = userService;
    }

    @ModelAttribute("address")
    public Address modelAddress() {
        return new Address();
    }

    @GetMapping("/editDetails")
    public String getEditPage(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "editPersonalInfo";
    }

    @GetMapping("/info")
    public String getInfoPage(Model model){
        Contact userContact = contactService.findUserContact();
        model.addAttribute("contact",userContact);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "personalInfo";
    }

    @PostMapping("/saveDetails")
    public String saveDetails(Address address, @RequestParam(value = "telephone", required = false) String telephone,
                              @RequestParam(value = "email", required = false) String email){
        contactService.saveHomeAddress(address, telephone, email);
        return "redirect:/info";
    }

}

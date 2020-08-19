package by.work.web.controller;

import by.work.database.entity.Address;
import by.work.database.entity.Category;
import by.work.database.entity.Contact;
import by.work.database.entity.User;
import by.work.service.CategoryService;
import by.work.service.ContactService;
import by.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @ModelAttribute("contact")
    public Contact modelContact() {
        Contact contact = contactService.findUserContact();
        if(contact==null){
            return contactService.getEmptyContact();
        }else
        return contact;
    }

    @GetMapping("/editDetails")
    public String getEditPage(Model model) {
        //this is need to display a dropdown content of navBar
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "editPersonalInfo";
    }

    @GetMapping("/info")
    public String getInfoPage(Model model) {
        Contact userContact = contactService.findUserContact();
        model.addAttribute("contact", userContact);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "personalInfo";
    }

    @GetMapping("/seller/{id}")
    public String getSellerPage(@PathVariable("id") Long id, Model model){
        User user = userService.findUserById(id);
        Contact contact = contactService.findByUser(user);
        model.addAttribute("contact", contact);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "seller";
    }

    @PostMapping("/saveDetails")
    public String saveDetails(Address address, @RequestParam(value = "telephone", required = false) String telephone,
                              @RequestParam(value = "email", required = false) String email) {
        contactService.saveHomeAddress(address, telephone, email);
        return "redirect:/info";
    }

}

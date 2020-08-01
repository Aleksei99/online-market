package by.work.web.controller;

import by.work.database.entity.Address;
import by.work.database.entity.Contact;
import by.work.database.entity.User;
import by.work.service.ContactService;
import by.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    private final ContactService contactService;
    private final UserService userService;

    @Autowired
    public ContactController(ContactService contactService, UserService userService) {
        this.contactService = contactService;
        this.userService = userService;
    }

    @ModelAttribute("address")
    public Address modelAddress() {
        return new Address();
    }

    @GetMapping("/editDetails")
    public String getEditPage() {
        return "editPersonalInfo";
    }

    @GetMapping("/info")
    public String getInfoPage(Model model){
        Contact userContact = contactService.findUserContact();
        model.addAttribute("contact",userContact);
        return "personalInfo";
    }

    @PostMapping("/saveDetails")
    public String saveDetails(Address address, @RequestParam(value = "telephone", required = false) String telephone,
                              @RequestParam(value = "email", required = false) String email){
        contactService.saveHomeAddress(address, telephone, email);
        return "personalInfo";
    }

}

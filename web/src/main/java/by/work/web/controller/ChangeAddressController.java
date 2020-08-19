package by.work.web.controller;

import by.work.database.entity.Address;
import by.work.database.entity.Category;
import by.work.service.CategoryService;
import by.work.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ChangeAddressController {

    private final ContactService contactService;
    private final CategoryService categoryService;

    public ChangeAddressController(ContactService contactService, CategoryService categoryService) {
        this.contactService = contactService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("address")
    public Address modelCategory() {
        return new Address();
    }

    @GetMapping("/address/another")
    public String getPage(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "otherAddress";
    }

    @PostMapping("/address/change")
    public String save(Address another){
        contactService.saveAnotherAddress(another);
        return "redirect:/ordering";
    }

    @GetMapping("/address/home")
    public String getHome(){
        contactService.changeAddress();
        return "redirect:/ordering";
    }
}

package by.work.web.controller;

import by.work.database.entity.Address;
import by.work.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChangeAddressController {

    private final ContactService contactService;

    public ChangeAddressController(ContactService contactService) {
        this.contactService = contactService;
    }

    @ModelAttribute("address")
    public Address modelCategory() {
        return new Address();
    }

    @GetMapping("/address/another")
    public String getPage(){
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

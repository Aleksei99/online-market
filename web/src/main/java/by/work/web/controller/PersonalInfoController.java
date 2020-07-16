package by.work.web.controller;

import by.work.database.entity.PersonalInfo;
import by.work.database.entity.User;
import by.work.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class PersonalInfoController {

    private final PersonalInfoService personalInfoService;

    @Autowired
    public PersonalInfoController(PersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }

    @ModelAttribute("info")
    public PersonalInfo modelInfo() {
        PersonalInfo personalInfo = new PersonalInfo();
        return personalInfo;
    }

    @GetMapping("/registrationPI")
    public String getRegistrationPIPage() {
        return "registrationPI";
    }

    @PostMapping("/registrationPI")
    public String savePersonalInfo(@Valid PersonalInfo personalInfo, Errors errors, HttpSession httpSession) {
        if (errors.hasErrors()) {
            return "registrationPI";
        }
        User user = (User) httpSession.getAttribute("user");
        personalInfoService.save(new PersonalInfo(user, personalInfo.getLogin(), personalInfo.getPassword()));
        return "redirect:/home";
    }
}

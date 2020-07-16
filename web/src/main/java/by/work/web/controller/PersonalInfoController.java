package by.work.web.controller;

import by.work.database.entity.PersonalInfo;
import by.work.database.entity.User;
import by.work.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

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
    public String getRegistrationPage(@ModelAttribute("user") User data) {
        System.out.println(data.getId());
        return "registrationPI";
    }

    @PostMapping("/registrationPI")
    public String savePersonalInfo(PersonalInfo personalInfo, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        String login= personalInfo.getLogin();
        String password = personalInfo.getPassword();
        personalInfoService.save(new PersonalInfo(user, personalInfo.getLogin(), personalInfo.getPassword()));
        return "redirect:/home";
    }
}

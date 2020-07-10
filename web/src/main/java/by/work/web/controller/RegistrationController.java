package by.work.web.controller;

import by.work.database.entity.Role;
import by.work.database.entity.User;
import by.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User modelUser() {
        User user = new User();
        return user;
    }


    @ModelAttribute("allRoles")
    public Role[] allRoles() {
        return Role.values();
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(User user,
                           RedirectAttributes redirectAttributes, HttpSession session) {
        userService.save(user);
        session.setAttribute("user", user);
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/registrationPI";
    }

}

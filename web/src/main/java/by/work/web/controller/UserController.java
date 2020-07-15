package by.work.web.controller;

import by.work.service.UserService;
import by.work.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public String UserPage(@PathVariable("id") Long id, Model model) {
        UserDTO user = userService.findById(id);
        model.addAttribute("user", user);
        return "user";
    }
}

package by.work.web.controller;

import by.work.database.entity.Category;
import by.work.database.entity.User;
import by.work.service.CategoryService;
import by.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final CategoryService categoryService;

    private final UserService userService;

    @Autowired
    public HomeController(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getHomePage(Model model, HttpSession session) {
        Iterable<Category> all = categoryService.getAll();
        List<Category> categories = new ArrayList<>();
        for (Category item : all) {
            categories.add(item);
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user = userService.findByLogin(username);
        session.setAttribute("currentUser", user);
        model.addAttribute("currentUser", user);
        model.addAttribute("categories", categories);
        return "home";
    }
}

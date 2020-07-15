package by.work.web.controller;

import by.work.database.entity.Category;
import by.work.database.entity.PersonalInfo;
import by.work.database.entity.User;
import by.work.service.CategoryService;
import by.work.service.PersonalInfoService;
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

    private final PersonalInfoService personalInfoService;

    @Autowired
    public HomeController(CategoryService categoryService, PersonalInfoService personalInfoService) {
        this.categoryService = categoryService;
        this.personalInfoService = personalInfoService;
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
        PersonalInfo personalInfo = personalInfoService.findPersonalInfo(username);
        User user = personalInfo.getUser();
        session.setAttribute("currentUser", user);
        model.addAttribute("currentUser", user);
        model.addAttribute("categories", categories);
        return "home";
    }
}

package by.work.web.controller;

import by.work.database.entity.Category;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRestController {

    @PostMapping("/admin")
    public Category addCategory(@RequestBody Category category) {
        return category;
    }

}

package by.work.web.controller;

import by.work.database.entity.Category;
import by.work.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminRestController {

    @PostMapping("/admin")
    public Category addCategory(@RequestBody Category category){
        return category;
    }

}

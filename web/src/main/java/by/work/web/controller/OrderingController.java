package by.work.web.controller;

import by.work.database.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class OrderingController {

    @ModelAttribute("order")
    public Order getOrder(HttpSession session){
        return (Order) session.getAttribute("currentOrder");
    }

    @GetMapping("/ordering")
    public String getPage(){
        return "ordering";
    }
}

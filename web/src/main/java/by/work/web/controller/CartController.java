package by.work.web.controller;

import by.work.database.entity.Basket;
import by.work.database.entity.Order;
import by.work.database.entity.Product;
import by.work.service.BasketService;
import by.work.service.OrderService;
import by.work.service.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Set;

@Controller
public class CartController {

    private final OrderService orderService;
    private final BasketService basketService;

    @Autowired
    public CartController(OrderService orderService, BasketService basketService) {
        this.orderService = orderService;
        this.basketService = basketService;
    }

    @ModelAttribute("modelOrder")
    public OrderDTO modelOrder() {
        return new OrderDTO();
    }

    @PostMapping("/ordering")
    public String post(OrderDTO dto, HttpSession session) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        Order order = (Order) session.getAttribute("currentOrder");
        for (int i = 0; i < dto.getCount().size(); i++) {
            for (int j = 0; j < dto.getPrice().size(); j++) {
                if (i == j) {
                    basketService.save(new Basket(order.getId(),dto.getIds().get(i),dto.getCount().get(i)));
                    totalAmount = totalAmount.add(new BigDecimal(dto.getCount().get(i)).multiply(dto.getPrice().get(j)));
                }
            }
        }
        orderService.update(order, totalAmount);
        return "redirect:/ordering";
    }

    @PostMapping("/product/remove")
    public String removeProduct(HttpSession session, @RequestParam(value = "id", required = false) Long id) {
        Order order = (Order) session.getAttribute("currentOrder");
        order.getProducts().removeIf(product -> product.getId().equals(id));
        session.removeAttribute("currentOrder");
        session.setAttribute("currentOrder", order);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String getPage(HttpSession session, Model model) {
        Order order = (Order) session.getAttribute("currentOrder");
        Set<Product> products = order.getProducts();
        model.addAttribute("cartProducts", products);
        return "cart";
    }

}

package pl.mkrtchyan.springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mkrtchyan.springbootapp.model.Order;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.model.User;
import pl.mkrtchyan.springbootapp.service.OrderService;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/makeOrder")
    public String makeOrder(Model model) {
        List<Product> products = orderService.getAllProducts();
        model.addAttribute("products", products);
        return "makeOrder";
    }

    @GetMapping("/make-order-form")
    public String makeOrderShowForm(Model model) {
        Order order = new Order();
        List<Product> products = orderService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("order", order);
        return "makeOrder";
    }

    @PostMapping("/make-order-form")
    public String makeOrderForm(@ModelAttribute User user, @RequestParam("quantity") double quantity, @RequestParam("productId") Long productId, Model model) {

        Product product = orderService.getProductById(productId);
        model.addAttribute("product", product);
        model.addAttribute("quantity", quantity);

        User savedUser = orderService.saveUser(user);

        Order order = orderService.createOrder(savedUser, quantity, productId);

        return "order_confirmation";
    }
}
package pl.mkrtchyan.springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mkrtchyan.springbootapp.model.Order;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.model.User;
import pl.mkrtchyan.springbootapp.repo.OrderRepository;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;
import pl.mkrtchyan.springbootapp.repo.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    public OrderController(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }


    @GetMapping("/makeOrder")
    public String makeOrder(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "makeOrder";
    }

    @GetMapping("/make-order-form")
    public String makeOrderShowForm(Model model) {
        Order order = new Order();
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("order", order);
        return "makeOrder";
    }

    @PostMapping("/make-order-form")
    public String makeOrderForm(@ModelAttribute User user, @RequestParam("quantity") double quantity, @RequestParam("productId") Long productId, Model model) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + productId));
        model.addAttribute("product", product);
        model.addAttribute("quantity", quantity);

        userRepository.save(user);

        Order order = new Order();
        order.setUser(user);
        order.setQuantity(quantity);
        order.setOrderTime(LocalDateTime.now());
        order.setProduct(product);

        orderRepository.save(order);

        return "order_confirmation";

    }


}




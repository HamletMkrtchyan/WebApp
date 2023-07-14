package pl.mkrtchyan.springbootapp.controller;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mkrtchyan.springbootapp.model.*;
import pl.mkrtchyan.springbootapp.repo.OpinionRepository;
import pl.mkrtchyan.springbootapp.repo.OrderRepository;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;
import pl.mkrtchyan.springbootapp.repo.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AdminController {

    private final ProductRepository productRepository;
    private final OpinionRepository opinionRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public AdminController(ProductRepository productRepository, OpinionRepository opinionRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.opinionRepository = opinionRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/admin")
    public String adminForm(@ModelAttribute Admin admin) {
        if (admin.getPassword().toLowerCase().equals("admin")) {
            return "adminPage";
        } else {
            return "admin";
        }
    }

    @GetMapping("/addProduct")
    public String ShowAddProductForm(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("products", products);
        return "addProduct";
    }

    @PostMapping("/productAdd")
    public String DoAddProductForm(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        productRepository.save(product);
        return "redirect:/addProduct";

    }

    @PostMapping("/goBackAdminPage")
    public String goBackAdminPage() {
        return "adminPage";
    }

    @GetMapping("/deleteAddedProduct")
    public String deleteAddedProduct(@RequestParam("id") Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        List<Order> orders = orderRepository.findAllByProductId(id);
        orderRepository.deleteInBatch(orders);
        productRepository.deleteById(id);
        return "redirect:/addProduct";
    }

    @GetMapping("/updateAddedProduct")
    public String updateAddedProduct(@RequestParam("id") Long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "updateAddedProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        productRepository.save(product);
        return "redirect:/addProduct";
    }

    @PostMapping("/goBackAddPage")
    public String goBackAddPage() {
        return "addProduct";
    }


    @GetMapping("/opinionList")
    public String opinionList(Model model) {
        List<Opinion> opinions = opinionRepository.findAll();
        model.addAttribute("opinions", opinions);
        return "opinionList";

    }

    @GetMapping("/orderList")
    public String orderListShow(Model model) {
        List<Order> orders = orderRepository.findAll(Sort.by(Sort.Direction.DESC, "orderTime"));
        model.addAttribute("orders", orders);
        return "orderList";

    }

    @PostMapping("/mark-as-done")
    public String markOrderAsDone(@RequestParam("id") Long id, Model model) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + id));

        orderRepository.delete(order);
        return "redirect:/orderList";

    }


}


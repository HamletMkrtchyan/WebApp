package pl.mkrtchyan.springbootapp.controller;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mkrtchyan.springbootapp.model.*;
import pl.mkrtchyan.springbootapp.repo.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AdminController {

    private final ProductRepository productRepository;
    private final OpinionRepository opinionRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ContactMailRepository contactMailRepository;

    public AdminController(ProductRepository productRepository, OpinionRepository opinionRepository, OrderRepository orderRepository, UserRepository userRepository, ContactMailRepository contactMailRepository) {
        this.productRepository = productRepository;
        this.opinionRepository = opinionRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.contactMailRepository = contactMailRepository;
    }

    @PostMapping("/admin")
    public String adminForm(@ModelAttribute Admin admin, Model model) {
        if (admin.getPassword().toLowerCase().equals("admin")) {
            List<ContactMail> contactMails = contactMailRepository.findAllByOrderByDateDesc();
            model.addAttribute("contactMails", contactMails);
            return "adminPage";
        } else {
            return "admin";
        }
    }


    @GetMapping("/addProduct")
    public String ShowAddProductForm(Model model) {
        List<Product> products = productRepository.findAllByOrderByDateDesc();
        model.addAttribute("product", new Product());
        model.addAttribute("products", products);
        return "addProduct";
    }


    @PostMapping("/productAdd")
    public String DoAddProductForm(@ModelAttribute Product product, Model model) {
        product.setDate(LocalDateTime.now());
        model.addAttribute("product", product);
       if (productRepository.existsByName(product.getName())){
           return "redirect:/addProduct";
       }
        productRepository.save(product);
        return "redirect:/addProduct";

    }


    @PostMapping("/goBackAdminPage")
    public String goBackAdminPage(Model model) {
        List<ContactMail> contactMails = contactMailRepository.findAll();
        model.addAttribute("contactMails", contactMails);
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
        List<Opinion> opinions = opinionRepository.findAllByOrderByDateDesc();
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


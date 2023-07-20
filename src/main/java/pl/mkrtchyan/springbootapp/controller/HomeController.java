package pl.mkrtchyan.springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.repo.ContactMailRepository;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;

import java.util.List;

@Controller
public class HomeController {
    private final ProductRepository productRepository;
    private final ContactMailRepository contactMailRepository;

    public HomeController(ProductRepository productRepository, ContactMailRepository contactMailRepository) {
        this.productRepository = productRepository;
        this.contactMailRepository = contactMailRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about_us";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        List<ContactMail> contactMails = contactMailRepository.findAll();
        model.addAttribute("contactMails", contactMails);
        return "contact";
    }


    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

}

package pl.mkrtchyan.springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.service.HomeService;
import pl.mkrtchyan.springbootapp.service.ProductService;

import java.util.List;

@Controller
public class HomeController {
private final HomeService homeService;
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = homeService.getAllProducts();
        model.addAttribute("products", products);
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about_us";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        List<ContactMail> contactMails = homeService.getAllContactMails();
        model.addAttribute("contactMails", contactMails);
        return "contact";
    }


    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

}

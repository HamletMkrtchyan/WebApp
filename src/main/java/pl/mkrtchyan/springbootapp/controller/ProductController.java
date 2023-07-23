package pl.mkrtchyan.springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;
import pl.mkrtchyan.springbootapp.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String product(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/productSearch")
    public String productSearchForm(@RequestParam("search") String search, Model model) {
        List<Product> products = productService.getAllProducts();
        List<Product> matchedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(search.toLowerCase())) {
                matchedProducts.add(product);
            }
        }
        if (matchedProducts.isEmpty()) {
            model.addAttribute("errorMessage", "Nie znaleziono produktu.");
        }
        model.addAttribute("products", matchedProducts);
        return "product";

    }

    @GetMapping("/goBackAllProductPage")
    public String goBackAllProductPage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product";
    }
}

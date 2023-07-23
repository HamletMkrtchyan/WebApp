package pl.mkrtchyan.springbootapp.controller;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mkrtchyan.springbootapp.model.*;
import pl.mkrtchyan.springbootapp.service.AdminService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/admin")
    public String adminForm(@ModelAttribute Admin admin, Model model) {
        if (admin.getPassword().toLowerCase().equals("admin")) {
            List<ContactMail> contactMails = adminService.getAllContactMailsByDate();
            model.addAttribute("contactMails", contactMails);
            return "adminPage";
        } else {
            return "admin";
        }
    }


    @GetMapping("/addProduct")
    public String ShowAddProductForm(Model model) {
        List<Product> products = adminService.getAllProductsByDate();
        model.addAttribute("product", new Product());
        model.addAttribute("products", products);
        return "addProduct";
    }


    @PostMapping("/productAdd")
    public String DoAddProductForm(@ModelAttribute Product product, Model model) {
        product.setDate(LocalDateTime.now());
        model.addAttribute("product", product);
        if (adminService.existsByName(product)) {
            return "redirect:/addProduct";
        }
        adminService.saveProduct(product);
        return "redirect:/addProduct";

    }


    @PostMapping("/goBackAdminPage")
    public String goBackAdminPage(Model model) {
        List<ContactMail> contactMails = adminService.getAllContactMails();
        model.addAttribute("contactMails", contactMails);
        return "adminPage";
    }


    @GetMapping("/deleteAddedProduct")
    public String deleteAddedProduct(@RequestParam("id") Long id) {
        Product product = adminService.getProductById(id);
        List<Order> orders = adminService.getAllProductsById(id);
        adminService.deleteOrdersInBatch(orders);
        adminService.deleteProductById(id);
        return "redirect:/addProduct";
    }


    @GetMapping("/updateAddedProduct")
    public String updateAddedProduct(@RequestParam("id") Long id, Model model) {
        Product product = adminService.getProductById(id);
        model.addAttribute("product", product);
        return "updateAddedProduct";
    }


    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        adminService.saveProduct(product);
        return "redirect:/addProduct";
    }


    @PostMapping("/goBackAddPage")
    public String goBackAddPage() {
        return "addProduct";
    }


    @GetMapping("/opinionList")
    public String opinionList(Model model) {
        List<Opinion> opinions = adminService.getAllOpinionsByDate();
        model.addAttribute("opinions", opinions);
        return "opinionList";

    }


    @GetMapping("/orderList")
    public String orderListShow(Model model) {
        List<Order> orders = adminService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orderList";

    }


    @PostMapping("/mark-as-done")
    public String markOrderAsDone(@RequestParam("id") Long id, Model model) {
        Order order = adminService.getOrderById(id);

       adminService.deleteOrder(order);
        return "redirect:/orderList";

    }


}


package pl.mkrtchyan.springbootapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.mkrtchyan.springbootapp.model.*;
import pl.mkrtchyan.springbootapp.service.AdminService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AdminControllerTest {

    @Mock
    private AdminService adminService;

    @Mock
    private Model model;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdminForm() {
        Admin admin = new Admin();
        admin.setPassword("ADMIN");
        List<ContactMail> contactMails = Arrays.asList(new ContactMail(), new ContactMail());
        when(adminService.getAllContactMailsByDate()).thenReturn(contactMails);

        String viewName = adminController.adminForm(admin, model);

        verify(model).addAttribute("contactMails", contactMails);
        assertEquals("adminPage", viewName);
    }

    @Test
    public void testShowAddProductForm() {
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(adminService.getAllProductsByDate()).thenReturn(products);

        String viewName = adminController.ShowAddProductForm(model);

        verify(model).addAttribute(eq("product"), any(Product.class));
        verify(model).addAttribute("products", products);
        assertEquals("addProduct", viewName);
    }


    @Test
    public void testDoAddProductForm() {
        Product product = new Product();
        product.setDate(LocalDateTime.now());

        when(adminService.existsByName(product)).thenReturn(false);

        String viewName = adminController.DoAddProductForm(product, model);

        verify(adminService).saveProduct(product);
        assertEquals("redirect:/addProduct", viewName);
    }

    @Test
    public void testGoBackAdminPage() {
        List<ContactMail> contactMails = Arrays.asList(new ContactMail(), new ContactMail());
        when(adminService.getAllContactMails()).thenReturn(contactMails);

        String viewName = adminController.goBackAdminPage(model);

        verify(model).addAttribute("contactMails", contactMails);
        assertEquals("adminPage", viewName);
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setDate(LocalDateTime.now());

        String viewName = adminController.updateProduct(product, model);

        verify(adminService).saveProduct(product);
        assertEquals("redirect:/addProduct", viewName);
    }

    @Test
    public void testGoBackAddPage() {
        String viewName = adminController.goBackAddPage();
        assertEquals("addProduct", viewName);
    }

    @Test
    public void testOpinionList() {
        List<Opinion> opinions = Arrays.asList(new Opinion(), new Opinion());
        when(adminService.getAllOpinionsByDate()).thenReturn(opinions);

        String viewName = adminController.opinionList(model);

        verify(model).addAttribute("opinions", opinions);
        assertEquals("opinionList", viewName);
    }

    @Test
    public void testOrderListShow() {
        List<Order> orders = Arrays.asList(new Order(), new Order());
        when(adminService.getAllOrders()).thenReturn(orders);

        String viewName = adminController.orderListShow(model);

        verify(model).addAttribute("orders", orders);
        assertEquals("orderList", viewName);
    }

    @Test
    public void testMarkOrderAsDone() {
        Long id = 1L;
        Order order = new Order();
        order.setId(id);
        when(adminService.getOrderById(id)).thenReturn(order);

        String viewName = adminController.markOrderAsDone(id, model);

        verify(adminService).deleteOrder(order);
        assertEquals("redirect:/orderList", viewName);
    }
}

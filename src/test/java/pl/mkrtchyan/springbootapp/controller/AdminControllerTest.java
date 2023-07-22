package pl.mkrtchyan.springbootapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.mkrtchyan.springbootapp.model.Admin;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.Order;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.repo.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdminControllerTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private OpinionRepository opinionRepository;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ContactMailRepository contactMailRepository;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdminForm() {
        Admin admin = new Admin();
        admin.setPassword("admin");

        Model model = mock(Model.class);
        List<ContactMail> contactMails = Arrays.asList(new ContactMail(), new ContactMail());
        when(contactMailRepository.findAllByOrderByDateDesc()).thenReturn(contactMails);

        String viewName = adminController.adminForm(admin, model);

        assertEquals("adminPage", viewName);
        verify(model).addAttribute("contactMails", contactMails);
    }

    @Test
    public void testAdminFormWithWrongPassword() {
        Admin admin = new Admin();
        admin.setPassword("wrong_password");

        Model model = mock(Model.class);

        String viewName = adminController.adminForm(admin, model);

        assertEquals("admin", viewName);
    }

    @Test
    public void testShowAddProductForm() {
        Model model = mock(Model.class);
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productRepository.findAllByOrderByDateDesc()).thenReturn(products);

        String viewName = adminController.ShowAddProductForm(model);

        assertEquals("addProduct", viewName);
        verify(model).addAttribute(eq("product"), isA(Product.class));
        verify(model).addAttribute("products", products);
    }

    @Test
    public void testDoAddProductForm() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setDate(LocalDateTime.now());
        Model model = mock(Model.class);

        when(productRepository.existsByName(anyString())).thenReturn(false);

        String viewName = adminController.DoAddProductForm(product, model);

        assertEquals("redirect:/addProduct", viewName);
        verify(productRepository).save(product);
    }

    @Test
    public void testDeleteAddedProduct() {
        Long id = 1L;
        Product product = new Product();
        product.setId(id);

        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        String viewName = adminController.deleteAddedProduct(id);

        assertEquals("redirect:/addProduct", viewName);
        verify(orderRepository).deleteInBatch(anyList());
        verify(productRepository).deleteById(id);
    }


    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        Model model = mock(Model.class);

        String viewName = adminController.updateProduct(product, model);

        assertEquals("redirect:/addProduct", viewName);
        verify(productRepository).save(product);
    }

    @Test
    public void testMarkOrderAsDone() {
        Long id = 1L;
        Order order = new Order();
        order.setId(id);

        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));

        String viewName = adminController.markOrderAsDone(id, mock(Model.class));

        assertEquals("redirect:/orderList", viewName);
        verify(orderRepository).delete(order);
    }


}
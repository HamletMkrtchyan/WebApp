package pl.mkrtchyan.springbootapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;
import pl.mkrtchyan.springbootapp.model.*;
import pl.mkrtchyan.springbootapp.repo.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdminServiceTest {

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

    private AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        adminService = new AdminService(productRepository, opinionRepository, orderRepository, userRepository, contactMailRepository);
    }

    @Test
    void getAllContactMailsByDate() {
        List<ContactMail> contactMailList = Arrays.asList(new ContactMail(), new ContactMail());
        when(contactMailRepository.findAllByOrderByDateDesc()).thenReturn(contactMailList);

        List<ContactMail> result = adminService.getAllContactMailsByDate();

        assertEquals(contactMailList, result);
    }

    @Test
    void getAllProductsByDate() {
        List<Product> productList = Arrays.asList(new Product(), new Product());
        when(productRepository.findAllByOrderByDateDesc()).thenReturn(productList);

        List<Product> result = adminService.getAllProductsByDate();

        assertEquals(productList, result);
    }

    @Test
    void saveProduct() {
        Product product = new Product();
        when(productRepository.save(product)).thenReturn(product);

        Product result = adminService.saveProduct(product);

        assertEquals(product, result);
    }

    @Test
    void existsByName() {
        Product product = new Product();
        product.setName("Test Product");
        when(productRepository.existsByName(product.getName())).thenReturn(true);

        boolean result = adminService.existsByName(product);

        assertTrue(result);
    }

    @Test
    void getAllContactMails() {
        List<ContactMail> contactMailList = Arrays.asList(new ContactMail(), new ContactMail());
        when(contactMailRepository.findAll()).thenReturn(contactMailList);

        List<ContactMail> result = adminService.getAllContactMails();

        assertEquals(contactMailList, result);
    }

    @Test
    void getProductById() {
        Product product = new Product();
        Long id = 1L;
        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        Product result = adminService.getProductById(id);

        assertEquals(product, result);
    }

    @Test
    void getAllProductsById() {
        Long id = 1L;
        List<Order> orderList = Arrays.asList(new Order(), new Order());
        when(orderRepository.findAllByProductId(id)).thenReturn(orderList);

        List<Order> result = adminService.getAllProductsById(id);

        assertEquals(orderList, result);
    }

    @Test
    void deleteOrdersInBatch() {
        List<Order> orders = Arrays.asList(new Order(), new Order());
        doNothing().when(orderRepository).deleteInBatch(orders);

        adminService.deleteOrdersInBatch(orders);

        verify(orderRepository, times(1)).deleteInBatch(orders);
    }

    @Test
    void deleteProductById() {
        Long id = 1L;
        doNothing().when(productRepository).deleteById(id);

        adminService.deleteProductById(id);

        verify(productRepository, times(1)).deleteById(id);
    }

    @Test
    void getAllOpinionsByDate() {
        List<Opinion> opinionList = Arrays.asList(new Opinion(), new Opinion());
        when(opinionRepository.findAllByOrderByDateDesc()).thenReturn(opinionList);

        List<Opinion> result = adminService.getAllOpinionsByDate();

        assertEquals(opinionList, result);
    }

    @Test
    void getAllOrders() {
        List<Order> orderList = Arrays.asList(new Order(), new Order());
        Sort sort = Sort.by(Sort.Direction.DESC, "orderTime");
        when(orderRepository.findAll(sort)).thenReturn(orderList);

        List<Order> result = adminService.getAllOrders();

        assertEquals(orderList, result);
    }


    @Test
    void getOrderById() {
        Order order = new Order();
        Long id = 1L;
        when(orderRepository.findById(id)).thenReturn(Optional.of(order));

        Order result = adminService.getOrderById(id);

        assertEquals(order, result);
    }

    @Test
    void deleteOrder() {
        Order order = new Order();
        doNothing().when(orderRepository).delete(order);

        adminService.deleteOrder(order);

        verify(orderRepository, times(1)).delete(order);
    }


}


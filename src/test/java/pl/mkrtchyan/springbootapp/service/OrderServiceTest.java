package pl.mkrtchyan.springbootapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.mkrtchyan.springbootapp.model.Order;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.model.User;
import pl.mkrtchyan.springbootapp.repo.OrderRepository;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;
import pl.mkrtchyan.springbootapp.repo.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private UserRepository userRepository;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(orderRepository, productRepository, userRepository);
    }


    @Test
    void getAllProducts() {
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = orderService.getAllProducts();

        assertEquals(products, result);
    }

    @Test
    void getProductById() {

        Product product = new Product();
        Long productId = 1L;
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Product result = orderService.getProductById(productId);

        assertEquals(product, result);
    }

    @Test
    void saveUser() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        User result = orderService.saveUser(user);

        assertEquals(user, result);
    }

    @Test
    void createOrder() {
        User user = new User();
        Product product = new Product();
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));
        when(orderRepository.save(any(Order.class))).thenAnswer(i -> i.getArguments()[0]);

        Order result = orderService.createOrder(user, 2, 1L);

        assertEquals(user, result.getUser());
        assertEquals(product, result.getProduct());
        assertEquals(2, result.getQuantity());
    }
}
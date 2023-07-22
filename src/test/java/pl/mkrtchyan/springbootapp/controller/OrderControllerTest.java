package pl.mkrtchyan.springbootapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
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
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductRepository productRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testMakeOrder(){
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(products);

        Model model = mock(Model.class);

        String viewName = orderController.makeOrder(model);

        assertEquals("makeOrder", viewName);
        verify(model).addAttribute("products", products);
    }

    @Test
    void testMakeOrderShowForm() {

        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(products);

        Model model = mock(Model.class);

        String viewName = orderController.makeOrderShowForm(model);

        assertEquals("makeOrder", viewName);
        verify(model).addAttribute(eq("products"), eq(products));
        verify(model).addAttribute(eq("order"), isA(Order.class));
    }

    @Test
    void testMakeOrderForm(){
        User user = new User();
        double quantity = 5.0;
        Long productId = 1L;
        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Model model = mock(Model.class);

        String viewName = orderController.makeOrderForm(user, quantity, productId, model);

        assertEquals("order_confirmation", viewName);
        verify(userRepository).save(user);
        verify(orderRepository).save(any(Order.class));

    }



}
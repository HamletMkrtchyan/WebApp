package pl.mkrtchyan.springbootapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.mkrtchyan.springbootapp.model.Order;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.model.User;
import pl.mkrtchyan.springbootapp.service.OrderService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    private OrderService orderService;
    @Mock
    private Model model;

    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderController = new OrderController(orderService);
    }

    @Test
    void makeOrder() {
        List<Product> productList = Collections.singletonList(new Product());
        when(orderService.getAllProducts()).thenReturn(productList);

        String viewName = orderController.makeOrder(model);

        verify(model, times(1)).addAttribute("products", productList);
        assertEquals("makeOrder", viewName);
    }

    @Test
    void makeOrderShowForm() {
        Order order = new Order();
        List<Product> productList = Collections.singletonList(new Product());
        when(orderService.getAllProducts()).thenReturn(productList);

        String viewName = orderController.makeOrderShowForm(model);

        verify(model, times(1)).addAttribute("products", productList);
        verify(model, times(1)).addAttribute("order", order);
        assertEquals("makeOrder", viewName);
    }

    @Test
    void makeOrderForm() {
        User user = new User();
        Product product = new Product();
        double quantity = 1;
        Long productId = 1L;
        when(orderService.getProductById(any(Long.class))).thenReturn(product);
        when(orderService.saveUser(any(User.class))).thenReturn(user);
        when(orderService.createOrder(any(User.class), any(Double.class), any(Long.class))).thenReturn(new Order());

        String viewName = orderController.makeOrderForm(user, quantity, productId, model);

        verify(model, times(1)).addAttribute("product", product);
        verify(model, times(1)).addAttribute("quantity", quantity);
        assertEquals("order_confirmation", viewName);
    }
}

package pl.mkrtchyan.springbootapp.service;

import org.springframework.stereotype.Service;
import pl.mkrtchyan.springbootapp.model.Order;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.model.User;
import pl.mkrtchyan.springbootapp.repo.OrderRepository;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;
import pl.mkrtchyan.springbootapp.repo.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + productId));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Order createOrder(User user, double quantity, Long productId) {
        Product product = getProductById(productId);

        Order order = new Order();
        order.setUser(user);
        order.setQuantity(quantity);
        order.setOrderTime(LocalDateTime.now());
        order.setProduct(product);

        return orderRepository.save(order);
    }
}
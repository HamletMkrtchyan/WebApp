package pl.mkrtchyan.springbootapp.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.Opinion;
import pl.mkrtchyan.springbootapp.model.Order;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.repo.*;

import java.util.List;

@Service
public class AdminService {

    private final ProductRepository productRepository;
    private final OpinionRepository opinionRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ContactMailRepository contactMailRepository;

    public AdminService(ProductRepository productRepository, OpinionRepository opinionRepository, OrderRepository orderRepository, UserRepository userRepository, ContactMailRepository contactMailRepository) {
        this.productRepository = productRepository;
        this.opinionRepository = opinionRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.contactMailRepository = contactMailRepository;
    }

    public List<ContactMail> getAllContactMailsByDate() {
        return contactMailRepository.findAllByOrderByDateDesc();
    }

    public List<Product> getAllProductsByDate() {
        return productRepository.findAllByOrderByDateDesc();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean existsByName(Product product) {
        return productRepository.existsByName(product.getName());
    }


    public List<ContactMail> getAllContactMails() {
        return contactMailRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
    }

    public List<Order> getAllProductsById(Long id) {
        return orderRepository.findAllByProductId(id);
    }

    public void deleteOrdersInBatch(List<Order> orders) {
        orderRepository.deleteInBatch(orders);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Opinion> getAllOpinionsByDate() {
        return opinionRepository.findAllByOrderByDateDesc();
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "orderTime"));
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + id));
    }

    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }
}

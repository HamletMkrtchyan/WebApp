package pl.mkrtchyan.springbootapp.service;

import org.springframework.stereotype.Service;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


}

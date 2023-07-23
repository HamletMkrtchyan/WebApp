package pl.mkrtchyan.springbootapp.service;

import org.springframework.stereotype.Service;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.repo.ContactMailRepository;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;

import java.util.List;

@Service
public class HomeService {
    private final ProductRepository productRepository;
    private final ContactMailRepository contactMailRepository;

    public HomeService(ProductRepository productRepository, ContactMailRepository contactMailRepository) {
        this.productRepository = productRepository;
        this.contactMailRepository = contactMailRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<ContactMail> getAllContactMails(){
        return contactMailRepository.findAll();
    }

}

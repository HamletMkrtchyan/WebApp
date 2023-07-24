package pl.mkrtchyan.springbootapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.repo.ContactMailRepository;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class HomeServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ContactMailRepository contactMailRepository;

    private HomeService homeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        homeService = new HomeService(productRepository, contactMailRepository);
    }

    @Test
    void getAllProducts() {
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(products);


        List<Product> result = homeService.getAllProducts();
        assertEquals(products, result);

    }

    @Test
    void getAllContactMails() {
        List<ContactMail> contactMailList = Arrays.asList(new ContactMail(), new ContactMail());
        when(contactMailRepository.findAll()).thenReturn(contactMailList);

        List<ContactMail> result = homeService.getAllContactMails();

        assertEquals(contactMailList, result);
    }
}
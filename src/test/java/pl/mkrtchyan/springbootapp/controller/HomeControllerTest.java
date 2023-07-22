package pl.mkrtchyan.springbootapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.repo.ContactMailRepository;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class HomeControllerTest {
    @InjectMocks
    HomeController homeController;
    @Mock
    ProductRepository productRepository;
    @Mock
    ContactMailRepository contactMailRepository;
    @Mock
    Model model;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testHome() {
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(products);

        String viewName = homeController.home(model);

        assertEquals("home", viewName);
    }

    @Test
    void testAbout() {
        String viewName = homeController.about();

        assertEquals("about_us", viewName);
    }

    @Test
    void testContact() {
        List<ContactMail> contactMails = Arrays.asList(new ContactMail(), new ContactMail());
        when(contactMailRepository.findAll()).thenReturn(contactMails);

        String viewName = homeController.contact(model);

        assertEquals("contact", viewName);
    }

    @Test
    void testAdmin() {
        String viewName = homeController.admin();

        assertEquals("admin", viewName);
    }



}
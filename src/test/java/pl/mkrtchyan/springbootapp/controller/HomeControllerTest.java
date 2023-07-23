package pl.mkrtchyan.springbootapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.service.HomeService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class HomeControllerTest {

    @Mock
    private HomeService homeService;
    @Mock
    private Model model;

    private HomeController homeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        homeController = new HomeController(homeService);
    }

    @Test
    void home() {
        List<Product> productList = Collections.singletonList(new Product());
        when(homeService.getAllProducts()).thenReturn(productList);

        String viewName = homeController.home(model);

        assertEquals("home", viewName);
    }

    @Test
    void about() {
        String viewName = homeController.about();

        assertEquals("about_us", viewName);
    }

    @Test
    void contact() {
        List<ContactMail> contactMailList = Collections.singletonList(new ContactMail());
        when(homeService.getAllContactMails()).thenReturn(contactMailList);

        String viewName = homeController.contact(model);

        assertEquals("contact", viewName);
    }

    @Test
    void admin() {
        String viewName = homeController.admin();

        assertEquals("admin", viewName);
    }
}

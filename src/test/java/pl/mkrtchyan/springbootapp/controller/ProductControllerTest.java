package pl.mkrtchyan.springbootapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class ProductControllerTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void productSearchFormShouldReturnMatchedProducts() {

        Product product1 = new Product();
        product1.setName("Produkt 1");
        Product product2 = new Product();
        product2.setName("Produkt 2");
        List<Product> products = Arrays.asList(product1, product2);

        when(productRepository.findAll()).thenReturn(products);

        Model model = new BindingAwareModelMap();


        String viewName = productController.productSearchForm("Produkt 1", model);


        assertNotNull(viewName);
        assertEquals("product", viewName);

        List<Product> modelProducts = (List<Product>) model.getAttribute("products");
        assertNotNull(modelProducts);
        assertEquals(1, modelProducts.size());
        assertEquals(product1, modelProducts.get(0));
    }
}

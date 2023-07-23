package pl.mkrtchyan.springbootapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.mkrtchyan.springbootapp.model.Product;
import pl.mkrtchyan.springbootapp.service.ProductService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;
    @Mock
    private Model model;

    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productController = new ProductController(productService);
    }

    @Test
    void product() {
        List<Product> productList = Arrays.asList(new Product(), new Product());
        when(productService.getAllProducts()).thenReturn(productList);

        String viewName = productController.product(model);

        verify(model, times(1)).addAttribute("products", productList);
        assertEquals("product", viewName);
    }

    @Test
    void productSearchForm() {
        String search = "test";
        Product product1 = new Product();
        product1.setName("testProduct");
        Product product2 = new Product();
        product2.setName("anotherProduct");

        List<Product> productList = Arrays.asList(product1, product2);
        when(productService.getAllProducts()).thenReturn(productList);

        String viewName = productController.productSearchForm(search, model);

        verify(model, times(1)).addAttribute("products", Arrays.asList(product1));
        assertEquals("product", viewName);
    }

    @Test
    void goBackAllProductPage() {
        List<Product> productList = Arrays.asList(new Product(), new Product());
        when(productService.getAllProducts()).thenReturn(productList);

        String viewName = productController.goBackAllProductPage(model);

        verify(model, times(1)).addAttribute("products", productList);
        assertEquals("product", viewName);
    }
}

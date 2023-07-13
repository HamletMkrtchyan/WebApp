package pl.mkrtchyan.springbootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mkrtchyan.springbootapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

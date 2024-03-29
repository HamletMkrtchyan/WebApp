package pl.mkrtchyan.springbootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mkrtchyan.springbootapp.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
    List<Product> findAllByOrderByDateDesc();


}

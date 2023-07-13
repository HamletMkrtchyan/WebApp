package pl.mkrtchyan.springbootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mkrtchyan.springbootapp.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByProductId(Long id);
}

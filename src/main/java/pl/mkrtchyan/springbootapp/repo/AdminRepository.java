package pl.mkrtchyan.springbootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mkrtchyan.springbootapp.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}

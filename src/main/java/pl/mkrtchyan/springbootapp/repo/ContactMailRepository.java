package pl.mkrtchyan.springbootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mkrtchyan.springbootapp.model.ContactMail;

public interface ContactMailRepository extends JpaRepository<ContactMail, Long> {
}

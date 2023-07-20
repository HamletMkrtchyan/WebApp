package pl.mkrtchyan.springbootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.Opinion;

import java.util.List;

public interface ContactMailRepository extends JpaRepository<ContactMail, Long> {
    List<ContactMail> findAllByOrderByDateDesc();

}

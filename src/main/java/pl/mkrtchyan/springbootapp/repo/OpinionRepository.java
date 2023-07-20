package pl.mkrtchyan.springbootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mkrtchyan.springbootapp.model.Opinion;

import java.util.List;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
    List<Opinion> findAllByOrderByDateDesc();

}

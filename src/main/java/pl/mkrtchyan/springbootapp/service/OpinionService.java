package pl.mkrtchyan.springbootapp.service;

import org.springframework.stereotype.Service;
import pl.mkrtchyan.springbootapp.model.Opinion;
import pl.mkrtchyan.springbootapp.repo.OpinionRepository;
import pl.mkrtchyan.springbootapp.repo.OrderRepository;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;
import pl.mkrtchyan.springbootapp.repo.UserRepository;

import java.security.PublicKey;
import java.util.List;

@Service
public class OpinionService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OpinionRepository opinionRepository;


    public OpinionService(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository, OpinionRepository opinionRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.opinionRepository = opinionRepository;
    }


    public List<Opinion> getAllOpinions(){
        return opinionRepository.findAll();
    }

    public  List<Opinion> getAllOpinionsByDate(){
        return opinionRepository.findAllByOrderByDateDesc();
    }

    public Opinion getOpinionById(Long opinionId){
        return opinionRepository.findById(opinionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + opinionId));

    }

    public Opinion saveOpinion(Opinion opinion){
        return opinionRepository.save(opinion);
    }


}

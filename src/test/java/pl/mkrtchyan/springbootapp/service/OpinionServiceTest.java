package pl.mkrtchyan.springbootapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.mkrtchyan.springbootapp.model.Opinion;
import pl.mkrtchyan.springbootapp.repo.OpinionRepository;
import pl.mkrtchyan.springbootapp.repo.OrderRepository;
import pl.mkrtchyan.springbootapp.repo.ProductRepository;
import pl.mkrtchyan.springbootapp.repo.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OpinionServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private OpinionRepository opinionRepository;

    private OpinionService opinionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        opinionService = new OpinionService(orderRepository, productRepository, userRepository, opinionRepository);
    }

    @Test
    void getAllOpinionsByDate() {
        List<Opinion> opinions = Arrays.asList(new Opinion(), new Opinion());
        when(opinionRepository.findAllByOrderByDateDesc()).thenReturn(opinions);

        List<Opinion> result = opinionService.getAllOpinionsByDate();

        assertEquals(opinions, result);

    }


    @Test
    void getAllOpinions() {
        List<Opinion> opinions = Arrays.asList(new Opinion(), new Opinion());
        when(opinionRepository.findAll()).thenReturn(opinions);

        List<Opinion> result = opinionService.getAllOpinions();

        assertEquals(opinions, result);
    }

    @Test
    void getOpinionById() {
        Opinion opinion = new Opinion();
        Long opinionId = 1L;
        when(opinionRepository.findById(opinionId)).thenReturn(Optional.of(opinion));

        Opinion result = opinionService.getOpinionById(opinionId);

        assertEquals(opinion, result);

    }

    @Test
    void saveOpinion() {
        Opinion opinion = new Opinion();
        when(opinionRepository.save(opinion)).thenReturn(opinion);

        Opinion result = opinionService.saveOpinion(opinion);

        assertEquals(opinion, result);
    }
}
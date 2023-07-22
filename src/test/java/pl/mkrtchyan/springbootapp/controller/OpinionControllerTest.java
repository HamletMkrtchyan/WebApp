package pl.mkrtchyan.springbootapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.mkrtchyan.springbootapp.model.Opinion;
import pl.mkrtchyan.springbootapp.repo.OpinionRepository;
import pl.mkrtchyan.springbootapp.repo.UserRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OpinionControllerTest {
    @Mock
    private OpinionRepository opinionRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private OpinionController opinionController;


    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testShowOpinionsForm() {
        List<Opinion> opinions = Arrays.asList(new Opinion(), new Opinion());
        when(opinionRepository.findAllByOrderByDateDesc()).thenReturn(opinions);

        Model model = mock(Model.class);

        String viewName = opinionController.showOpinionsForm(model);

        assertEquals("opinion", viewName);
        verify(model).addAttribute("opinions", opinions);
    }

    @Test
    void testDoOpinionForm() {

        Opinion opinion = new Opinion();
        Model model = mock(Model.class);

        String viewName = opinionController.DoOpinionForm(opinion, model);

        assertEquals("redirect:/opinions", viewName);
        verify(opinionRepository).save(opinion);
    }



}
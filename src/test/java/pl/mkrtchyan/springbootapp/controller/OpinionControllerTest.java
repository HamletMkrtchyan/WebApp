package pl.mkrtchyan.springbootapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.mkrtchyan.springbootapp.model.Opinion;
import pl.mkrtchyan.springbootapp.service.OpinionService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OpinionControllerTest {

    @Mock
    private OpinionService opinionService;
    @Mock
    private Model model;

    private OpinionController opinionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        opinionController = new OpinionController(opinionService);
    }

    @Test
    void showOpinionsForm() {
        List<Opinion> opinionList = Collections.singletonList(new Opinion());
        when(opinionService.getAllOpinionsByDate()).thenReturn(opinionList);

        String viewName = opinionController.showOpinionsForm(model);

        verify(model, times(1)).addAttribute("opinions", opinionList);
        assertEquals("opinion", viewName);
    }

    @Test
    void doOpinionForm() {
        Opinion opinion = new Opinion();
        when(opinionService.saveOpinion(any(Opinion.class))).thenReturn(opinion);

        String viewName = opinionController.DoOpinionForm(opinion, model);

        assertEquals("redirect:/opinions", viewName);
    }

    @Test
    void adminReply() {
        Long opinionId = 1L;
        String adminReply = "Admin reply";
        Opinion opinion = new Opinion();
        opinion.setAdminReply(adminReply);

        when(opinionService.getOpinionById(opinionId)).thenReturn(opinion);
        when(opinionService.saveOpinion(opinion)).thenReturn(opinion);
        List<Opinion> opinionList = Collections.singletonList(opinion);
        when(opinionService.getAllOpinionsByDate()).thenReturn(opinionList);

        String viewName = opinionController.adminReply(adminReply, opinionId, model);

        verify(model, times(1)).addAttribute("adminReply", adminReply);
        verify(model, times(1)).addAttribute("opinions", opinionList);
        assertEquals("opinionList", viewName);
    }
}

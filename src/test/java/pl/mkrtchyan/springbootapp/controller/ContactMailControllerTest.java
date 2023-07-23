package pl.mkrtchyan.springbootapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.User;
import pl.mkrtchyan.springbootapp.service.ContactMailService;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ContactMailControllerTest {

    @Mock
    private ContactMailService contactMailService;
    @Mock
    private Model model;
    private ContactMailController contactMailController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        contactMailController = new ContactMailController(contactMailService);
    }

    @Test
    void sendEmailForm() {

        ContactMail contactMail = new ContactMail();
        User user = new User();

        String viewName = contactMailController.sendEmailForm(contactMail, user, model);

        verify(contactMailService).saveUser(user);
        verify(contactMailService).saveContactMail(any(ContactMail.class));
        assertEquals("redirect:/contact", viewName);
    }
}

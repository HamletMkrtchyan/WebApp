package pl.mkrtchyan.springbootapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.User;
import pl.mkrtchyan.springbootapp.repo.ContactMailRepository;
import pl.mkrtchyan.springbootapp.repo.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

class ContactMailControllerTest {

    @InjectMocks
    ContactMailController contactMailController;

    @Mock
    ContactMailRepository contactMailRepository;

    @Mock
    UserRepository userRepository;

    @Mock
    Model model;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendEmailForm() {

        ContactMail contactMail = new ContactMail();
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(contactMailRepository.save(any(ContactMail.class))).thenReturn(contactMail);


        String viewName = contactMailController.sendEmailForm(contactMail, user, model);


        assertEquals("redirect:/contact", viewName);
    }
}

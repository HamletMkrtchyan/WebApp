package pl.mkrtchyan.springbootapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.User;
import pl.mkrtchyan.springbootapp.repo.ContactMailRepository;
import pl.mkrtchyan.springbootapp.repo.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ContactMailServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private ContactMailRepository contactMailRepository;

    private ContactMailService contactMailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        contactMailService = new ContactMailService(contactMailRepository, userRepository);
    }

    @Test
    void saveUser() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        User result = contactMailService.saveUser(user);

        assertEquals(user, result);
    }

    @Test
    void saveContactMail() {
        ContactMail contactMail = new ContactMail();
        when(contactMailRepository.save(contactMail)).thenReturn(contactMail);

        ContactMail result = contactMailService.saveContactMail(contactMail);

        assertEquals(contactMail, result);
    }
}

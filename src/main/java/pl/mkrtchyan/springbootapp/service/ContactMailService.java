package pl.mkrtchyan.springbootapp.service;

import org.springframework.stereotype.Service;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.User;
import pl.mkrtchyan.springbootapp.repo.ContactMailRepository;
import pl.mkrtchyan.springbootapp.repo.UserRepository;

@Service
public class ContactMailService {
    private final ContactMailRepository contactMailRepository;
    private final UserRepository userRepository;

    public ContactMailService(ContactMailRepository contactMailRepository, UserRepository userRepository) {
        this.contactMailRepository = contactMailRepository;
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ContactMail saveContactMail(ContactMail contactMail) {
        return contactMailRepository.save(contactMail);
    }
}

package pl.mkrtchyan.springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.User;
import pl.mkrtchyan.springbootapp.repo.ContactMailRepository;
import pl.mkrtchyan.springbootapp.repo.UserRepository;

import java.time.LocalDateTime;

@Controller
public class ContactMailController {
    private final ContactMailRepository contactMailRepository;
    private final UserRepository userRepository;

    public ContactMailController(ContactMailRepository contactMailRepository, UserRepository userRepository) {
        this.contactMailRepository = contactMailRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/sendEmail")
    public String sendEmailForm(@ModelAttribute ContactMail contactMail, @ModelAttribute User user, Model model) {
        contactMail.setDate(LocalDateTime.now());
        contactMail.setUser(user);
        userRepository.save(user);
        contactMailRepository.save(contactMail);


        return "redirect:/contact";

    }
}

package pl.mkrtchyan.springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mkrtchyan.springbootapp.model.ContactMail;
import pl.mkrtchyan.springbootapp.model.User;
import pl.mkrtchyan.springbootapp.service.ContactMailService;

import java.time.LocalDateTime;

@Controller
public class ContactMailController {
    private final ContactMailService contactMailService;

    public ContactMailController(ContactMailService contactMailService) {
        this.contactMailService = contactMailService;
    }

    @PostMapping("/sendEmail")
    public String sendEmailForm(@ModelAttribute ContactMail contactMail, @ModelAttribute User user, Model model) {
        contactMail.setDate(LocalDateTime.now());
        contactMail.setUser(user);
        contactMailService.saveUser(user);
        contactMailService.saveContactMail(contactMail);


        return "redirect:/contact";

    }
}

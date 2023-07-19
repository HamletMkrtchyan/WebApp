package pl.mkrtchyan.springbootapp.controller;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mkrtchyan.springbootapp.model.Opinion;
import pl.mkrtchyan.springbootapp.model.User;
import pl.mkrtchyan.springbootapp.repo.OpinionRepository;
import pl.mkrtchyan.springbootapp.repo.UserRepository;

import java.util.List;

@Controller
public class OpinionController {
    private final OpinionRepository opinionRepository;
    private final UserRepository userRepository;

    public OpinionController(OpinionRepository opinionRepository, UserRepository userRepository) {
        this.opinionRepository = opinionRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/opinions")
    public String showOpinionsForm(Model model) {
        List<Opinion> opinions = opinionRepository.findAll();
        model.addAttribute("opinions", opinions);
        return "opinion";
    }

    @PostMapping("/opinionForm")
    public String DoOpinionForm(@ModelAttribute Opinion opinion, Model model) {
        opinionRepository.save(opinion);
        return "redirect:/opinions";

    }


    @PostMapping("/adminReply")
    public String adminReply(@RequestParam("adminReply") String adminReply, @RequestParam("opinionId") Long opinionId, Model model) {
        model.addAttribute("adminReply", adminReply);
        Opinion opinion = opinionRepository.findById(opinionId).orElseThrow(() -> new IllegalArgumentException("Invalid opinion Id:" + opinionId));
        opinion.setAdminReply(adminReply);
        opinionRepository.save(opinion);

        List<Opinion> opinions = opinionRepository.findAll();
        model.addAttribute("opinions", opinions);

        return "opinionList";

    }
}

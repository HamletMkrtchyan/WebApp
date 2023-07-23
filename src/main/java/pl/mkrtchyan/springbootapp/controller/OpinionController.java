package pl.mkrtchyan.springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mkrtchyan.springbootapp.model.Opinion;
import pl.mkrtchyan.springbootapp.service.OpinionService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class OpinionController {
    private final OpinionService opinionService;

    public OpinionController(OpinionService opinionService) {
        this.opinionService = opinionService;
    }


    @GetMapping("/opinions")
    public String showOpinionsForm(Model model) {
        List<Opinion> opinions = opinionService.getAllOpinionsByDate();
        model.addAttribute("opinions", opinions);
        return "opinion";
    }

    @PostMapping("/opinionForm")
    public String DoOpinionForm(@ModelAttribute Opinion opinion, Model model) {
        opinion.setDate(LocalDateTime.now());
        opinionService.saveOpinion(opinion);
        return "redirect:/opinions";

    }

    @PostMapping("/adminReply")
    public String adminReply(@RequestParam("adminReply") String adminReply, @RequestParam("opinionId") Long opinionId, Model model) {

        model.addAttribute("adminReply", adminReply);
        Opinion opinion = opinionService.getOpinionById(opinionId);
        opinion.setAdminReply(adminReply);
        opinionService.saveOpinion(opinion);

        List<Opinion> opinions = opinionService.getAllOpinionsByDate();
        model.addAttribute("opinions", opinions);

        return "opinionList";

    }
}

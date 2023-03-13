package efrei.project.advancedprogramming.controller;

import efrei.project.advancedprogramming.model.Intern;
import efrei.project.advancedprogramming.model.Tutor;
import efrei.project.advancedprogramming.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("tutor", new Tutor());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(Tutor tutor){
        tutorService.saveTutor(tutor);
        return "register_success";
    }

    @GetMapping("/interns")
    public String viewUsersList(Model model) {
        List<Tutor> listTutors = tutorService.getAllTutors();
        model.addAttribute("listTutors", listTutors);
        return "interns";
    }

    /*@Autowired
    private TutorService tutorService;

    @GetMapping("")
    public List<Tutor> getAllTutors() {
        return tutorService.getAllTutors();
    }

    @PostMapping("")
    public Tutor createTutor(@RequestBody Tutor tutor) {
        return tutorService.saveTutor(tutor);
    }

    @GetMapping("/{id}")
    public Tutor getTutorById(@PathVariable Long id) {
        return tutorService.getTutorById(id);
    }

@DeleteMapping("/{id}")
    public void deleteTutorById(@PathVariable Long id) {
        tutorService.deleteTutor(id);
    }
     */
    /*
    @PutMapping("/{id}")
    public Tutor updateTutorById(@PathVariable Long id, @RequestBody Tutor tutor) {
        return tutorService.updateTutorById(id, tutor);
    }*/


/*
    @GetMapping("/{id}/interns")
    public List<Intern> getInternsByTutor(@PathVariable Long id){
        return tutorService.getAllInternsByTutor(id);
    }

 */
}
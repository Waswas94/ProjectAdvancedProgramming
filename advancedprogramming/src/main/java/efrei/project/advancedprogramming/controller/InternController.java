package efrei.project.advancedprogramming.controller;

import efrei.project.advancedprogramming.model.Intern;
import efrei.project.advancedprogramming.model.Tutor;
import efrei.project.advancedprogramming.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api/interns")
public class InternController {

    @Autowired
    private InternService internService;
/*
    @GetMapping("interns_list")
    public List<Intern> getAllInterns() {
        return internService.getAllInterns();
    }
 */
    /*
    @GetMapping("/interns_list")
    public String viewUsersList(Model model) {
        List<Intern> listInterns = internService.getAllInterns();
        model.addAttribute("listInterns", listInterns);
        return "interns";
    }
    */

    @GetMapping("/interns_list")
    public String getInternsByTutorId(Model model) {
        List<Intern> listInterns = internService.getInternsByTutorId(1L);
        model.addAttribute("listInterns", listInterns);
        return "interns";
    }
    /*
    @GetMapping("/tutor/{tutorId}")
    public List<Intern> getInternsByTutorId(@PathVariable Long tutorId) {
        return internService.getInternsByTutorId(tutorId);
    }
    */

    @GetMapping("/create_intern")
    public String showSignUpForm(Model model){
        model.addAttribute("intern", new Intern());
        return "create_user_form";
    }

    @PostMapping("/process_intern_registration")
    public String processRegistration(Intern intern, Model model){
        intern.setTutor(new Tutor(1L));
        internService.saveIntern(intern);
        return "register_success_intern";
    }

    @PostMapping
    public ResponseEntity<Intern> addIntern(@RequestBody Intern intern) {
        Intern savedIntern = internService.saveIntern(intern);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedIntern.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedIntern);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Intern> updateIntern(@PathVariable Long id, @RequestBody Intern intern) {
        if (internService.getInternById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        intern.setId(id);
        Intern updatedIntern = internService.saveIntern(intern);
        return ResponseEntity.ok(updatedIntern);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIntern(@PathVariable Long id) {
        if (internService.getInternById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        internService.deleteIntern(id);
        return ResponseEntity.noContent().build();
    }

}

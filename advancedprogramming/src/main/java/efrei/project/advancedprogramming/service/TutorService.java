package efrei.project.advancedprogramming.service;

import efrei.project.advancedprogramming.model.Intern;
import efrei.project.advancedprogramming.model.Tutor;

import java.util.List;



public interface TutorService {
    List<Tutor> getAllTutors();
/*
    List<Intern> getAllInternsByTutor(Long tutorId);

 */

    Tutor getTutorById(Long id);

    Tutor saveTutor(Tutor tutor);

    void deleteTutor(Long id);
}
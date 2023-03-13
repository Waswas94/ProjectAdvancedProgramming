package efrei.project.advancedprogramming.service;

import efrei.project.advancedprogramming.model.Intern;

import java.util.List;

public interface InternService {
    List<Intern> getAllInterns();

    List<Intern> getInternsByTutorId(Long tutorId);

    Intern getInternById(Long id);

    Intern saveIntern(Intern intern);

    void deleteIntern(Long id);
}

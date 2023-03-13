package efrei.project.advancedprogramming.service;

import efrei.project.advancedprogramming.model.Intern;
import efrei.project.advancedprogramming.model.Tutor;
import efrei.project.advancedprogramming.repository.TutorRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TutorServiceImpl implements TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }
/*
    @Override
    public List<Intern> getAllInternsByTutor(Long tutorId) {
        return tutorRepository.findById(tutorId).orElse(null).getInterns();
    }

 */

    @Override
    public Tutor getTutorById(Long id) {
        return tutorRepository.findById(id).orElse(null);
    }

    @Override
    public Tutor saveTutor(Tutor tutor) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = tutor.getPassword();
        String encodedPassword = encoder.encode(rawPassword);
        tutor.setPassword(encodedPassword);
        return tutorRepository.save(tutor);
    }

    @Override
    public void deleteTutor(Long id) {
        tutorRepository.deleteById(id);
    }
}
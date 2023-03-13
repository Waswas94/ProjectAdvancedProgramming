package efrei.project.advancedprogramming.service;

import efrei.project.advancedprogramming.model.Intern;
import efrei.project.advancedprogramming.repository.InternRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class InternServiceImpl implements InternService {

    @Autowired
    private InternRepository internRepository;

    @Override
    public List<Intern> getAllInterns() {
        return internRepository.findAll();
    }

    @Override
    public Intern getInternById(Long id) {
        return internRepository.findById(id).orElse(null);
    }

    @Override
    public List<Intern> getInternsByTutorId(Long tutorId) {
        return internRepository.findByTutorId(tutorId);
    }

    @Override
    public Intern saveIntern(Intern intern) {
        return internRepository.save(intern);
    }

    @Override
    public void deleteIntern(Long id) {
        internRepository.deleteById(id);
    }
}

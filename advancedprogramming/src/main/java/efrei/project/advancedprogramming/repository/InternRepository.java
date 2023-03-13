package efrei.project.advancedprogramming.repository;

import efrei.project.advancedprogramming.model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long> {

    List<Intern> findByTutorId(Long tutorId);
}

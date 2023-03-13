package efrei.project.advancedprogramming.repository;

import efrei.project.advancedprogramming.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    @Query("select u from Tutor u where u.email = ?1")
    Tutor findByEmail(String email);
}

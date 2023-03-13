package efrei.project.advancedprogramming.repository;

import static org.assertj.core.api.Assertions.assertThat;

import efrei.project.advancedprogramming.model.Tutor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class TutorRepositoryTests {

    @Autowired
    private TutorRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        Tutor tutor = new Tutor();
        tutor.setEmail("wassim@test.com");
        tutor.setFirstName("Wassim");
        tutor.setLastName("Mahroug");
        tutor.setPassword("password");

        Tutor savedTutor = repo.save(tutor);

        Tutor existTutor = entityManager.find(Tutor.class, savedTutor.getId());

        assertThat(existTutor.getEmail()).isEqualTo(tutor.getEmail());
    }

    @Test
    public void testFindTutorByEmail() {
        String email = "louisa@test.com";

        Tutor tutor = repo.findByEmail(email);

        assertThat(tutor).isNotNull();
    }
}

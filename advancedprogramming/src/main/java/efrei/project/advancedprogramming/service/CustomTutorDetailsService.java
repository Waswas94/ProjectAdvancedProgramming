package efrei.project.advancedprogramming.service;

import efrei.project.advancedprogramming.model.CustomTutorDetails;
import efrei.project.advancedprogramming.model.Tutor;
import efrei.project.advancedprogramming.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomTutorDetailsService implements UserDetailsService {

    @Autowired
    private TutorRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Tutor tutor = repo.findByEmail(email);
        if(tutor == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomTutorDetails(tutor);
    }
}

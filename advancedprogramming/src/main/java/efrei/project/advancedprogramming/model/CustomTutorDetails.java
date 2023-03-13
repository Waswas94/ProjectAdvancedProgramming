package efrei.project.advancedprogramming.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomTutorDetails implements UserDetails {
    private  Tutor tutor;

    public CustomTutorDetails(Tutor tutor) {
        this.tutor = tutor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return tutor.getPassword();
    }

    public Long getId() {
        return tutor.getId();
    }

    @Override
    public String getUsername() {
        return tutor.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return tutor.getFirstName() + " " + tutor.getLastName();
    }

}

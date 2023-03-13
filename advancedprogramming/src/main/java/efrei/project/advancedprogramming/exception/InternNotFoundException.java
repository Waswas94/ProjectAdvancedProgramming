package efrei.project.advancedprogramming.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InternNotFoundException extends RuntimeException {
    public InternNotFoundException(String message) {
        super(message);
    }
}

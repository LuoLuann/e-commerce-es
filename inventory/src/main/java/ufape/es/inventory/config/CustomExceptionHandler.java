package ufape.es.inventory.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(DuplicateRecordException.class)
    protected ResponseEntity<Object> handleDuplicateRecordException(DuplicateRecordException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("type", "DuplicateRecord");
        response.put("message", ex.getMessage());

        Map<String, Object> error = new HashMap<>();
        error.put("error", response);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("type", "ResourceNotFound");
        response.put("message", ex.getMessage());

        Map<String, Object> error = new HashMap<>();
        error.put("error", response);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

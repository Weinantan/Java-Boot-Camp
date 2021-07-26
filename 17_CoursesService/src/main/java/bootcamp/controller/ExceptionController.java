package bootcamp.controller;

import bootcamp.persistencemock.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFound(final NotFoundException exp) {
        ApiError apiError = new ApiError(LocalDateTime.now(),exp.getLocalizedMessage());
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}
// TODO Create a class to encapsulate the error details and use that with ResponseEntity to return the following, TODO 1. Error message, 2. Timestamp
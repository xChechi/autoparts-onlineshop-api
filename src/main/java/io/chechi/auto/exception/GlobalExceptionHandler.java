package io.chechi.auto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MakeNotFoundException.class)
    public ResponseEntity<String> handlerMakeNotFound (MakeNotFoundException msg) {
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<String> handlerModelNotFound (ModelNotFoundException msg) {
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PartNotFoundException.class)
    public ResponseEntity<String> handlerPartNotFound (PartNotFoundException msg) {
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handlerCategoryNotFound (CategoryNotFoundException msg) {
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.NOT_FOUND);
    }
}

package ufape.es.inventory.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ufape.es.core.exception.DuplicateRecordException;
import ufape.es.core.exception.ObjectNotFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    protected ResponseEntity<Object> handlerObjectNotFoundException(ObjectNotFoundException ex) {
        Map<String, String> resposta = new HashMap<String, String>();
        resposta.put("type", "ObjectNotFound");
        resposta.put("message", ex.getMessage());

        Map<String, Object> erro = new HashMap<>();
        erro.put("error", resposta);

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateRecordException.class)
    protected ResponseEntity<Object> handlerDuplicate(DuplicateRecordException ex) {
        Map<String, String> resposta = new HashMap<String, String>();
        resposta.put("type", "DuplicateRecord");
        resposta.put("message", ex.getMessage());

        Map<String, Object> erro = new HashMap<>();
        erro.put("error", resposta);

        return new ResponseEntity<>(erro, HttpStatus.CONFLICT);
    }
}

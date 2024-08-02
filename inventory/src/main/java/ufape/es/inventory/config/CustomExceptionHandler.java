package ufape.es.inventory.config;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ufape.es.inventory.service.exception.ObjectNotFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    protected ResponseEntity<Object> tratarExcecaoObjetoNaoEncontrado(ObjectNotFoundException ex) {
        Map<String, String> resposta = new HashMap<String, String>();
        resposta.put("tipo", "RecursoNaoEncontrado");
        resposta.put("mensagem", ex.getMessage());

        Map<String, Object> erro = new HashMap<>();
        erro.put("erro", resposta);

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }
}

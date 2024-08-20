package ufape.es.catalog.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import ufape.es.catalog.registration.DuplicateRecordException;
import ufape.es.catalog.registration.ObjectNotFoundException;

@ControllerAdvice
public class TratadorDeExcecaoCustomizada {

	@ExceptionHandler(DuplicateRecordException.class)
	protected ResponseEntity<Object> tratarExcecaoRegistroDuplicado(DuplicateRecordException ex) {
		Map<String, String> resposta = new HashMap<>();
		resposta.put("tipo", "RegistroDuplicado");
		resposta.put("mensagem", ex.getMessage());

		Map<String, Object> erro = new HashMap<>();
		erro.put("erro", resposta);

		return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	protected ResponseEntity<Object> tratarExcecaoObjetoNaoEncontrado(ObjectNotFoundException ex) {
		Map<String, String> resposta = new HashMap<>();
		resposta.put("tipo", "RecursoNaoEncontrado");
		resposta.put("mensagem", ex.getMessage());

		Map<String, Object> erro = new HashMap<>();
		erro.put("erro", resposta);

		return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
	}


}

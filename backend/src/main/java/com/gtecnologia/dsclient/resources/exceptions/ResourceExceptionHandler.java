package com.gtecnologia.dsclient.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gtecnologia.dsclient.services.exceptions.ClientNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ClientNotFoundException e, HttpServletRequest request) {
		StandardError resp = new StandardError();
		resp.setTimestamp(Instant.now());
		resp.setStatus(HttpStatus.NOT_FOUND.value());
		resp.setError("Recurso não encontrado");
		resp.setMessage(e.getMessage());
		resp.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}
}

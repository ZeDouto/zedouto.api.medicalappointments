package com.api.tcc.utils;

import javax.validation.ConstraintViolationException;

import javassist.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResourceException extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@Override
	public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
		String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
	
		return new ResponseEntity<Object>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ DataIntegrityViolationException.class, TransactionSystemException.class,
			ConstraintViolationException.class })
	public final ResponseEntity<Object> dataIntegrityViolationException(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ NotFoundException.class })
	public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

}

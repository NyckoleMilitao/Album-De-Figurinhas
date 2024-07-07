package com.prj.albumdefigurinhas.exceptions;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

      @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<Object> handleUsuarioNotFoundException(
            UsuarioNotFoundException ex, WebRequest request) {
        
        List<String> erros = Arrays.asList(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Usuário não encontrado", LocalDateTime.now(), erros);
        
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}

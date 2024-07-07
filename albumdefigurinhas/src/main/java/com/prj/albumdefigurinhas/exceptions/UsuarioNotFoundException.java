package com.prj.albumdefigurinhas.exceptions;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException() {
        super();
    }

    public UsuarioNotFoundException(String message) {
        super(message);
    }

    public UsuarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

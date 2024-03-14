package com.aristomobileapi.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class JwtException extends RuntimeException {
 
	private static final long serialVersionUID = 1L;

	public JwtException(String message) {
        super(message);
    }
}
package com.ms.android.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request) {
        
        String requestURI = request.getDescription(false);

        
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.getMessage(),
            requestURI
        );

        // Trả về response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}

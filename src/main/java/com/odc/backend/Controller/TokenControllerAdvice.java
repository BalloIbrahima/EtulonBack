package com.odc.backend.Controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.odc.backend.Message.Exeption.TokenRefreshException;
import com.odc.backend.Message.Reponse.ResponseMessage;

@RestControllerAdvice
public class TokenControllerAdvice {
    @ExceptionHandler(value = TokenRefreshException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<?> handleTokenRefreshException(TokenRefreshException ex, WebRequest request) {
        return ResponseMessage.generateResponse(
            new Date()+
            ex.getMessage(),HttpStatus.FORBIDDEN,
            request.getDescription(false));
    }
}

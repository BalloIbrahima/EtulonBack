package com.odc.backend.Configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.odc.backend.Message.Reponse.ResponseMessage;

@RestControllerAdvice
public class ExceptionRecupereur {

    // @ExceptionHandler({Exception.class})
    // ResponseEntity<?> traiterException(Exception e){
    //     return  ResponseMessage.generateResponse("exeption", HttpStatus.EXPECTATION_FAILED, e.getMessage());
    // }
    
}

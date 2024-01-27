package com.grupoconsiti.proyectoAguirre.configuration.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({
            ResponseStatusException.class
    })
    @ResponseBody
    protected ExceptionDetails conflictHandler(Exception ex, HttpServletRequest req) {
        return new ExceptionDetails(LocalDate.now(), ex, req);
    }

}

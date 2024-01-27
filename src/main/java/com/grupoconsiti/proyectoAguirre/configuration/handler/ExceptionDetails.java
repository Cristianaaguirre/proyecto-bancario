package com.grupoconsiti.proyectoAguirre.configuration.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class ExceptionDetails {

    private LocalDate local_date;
    private String message;
    private String uri;

    public ExceptionDetails(LocalDate local_date, Exception exception, HttpServletRequest url) {
        this.local_date = local_date;
        this.message = exception.getMessage();
        this.uri = url.getRequestURI();
    }
}
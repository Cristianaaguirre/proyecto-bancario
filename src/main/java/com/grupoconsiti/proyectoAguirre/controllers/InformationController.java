package com.grupoconsiti.proyectoAguirre.controllers;

import com.grupoconsiti.proyectoAguirre.services.IGetInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/information")
@RequiredArgsConstructor
public class InformationController {

    private final IGetInformation information;

    @GetMapping("/{cod}")
    public ResponseEntity<?> getInformation(@PathVariable Integer cod) {
        return ResponseEntity.ok(information.getDetails(cod));
    }

}

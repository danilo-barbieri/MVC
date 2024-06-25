package com.example.site.controller;

import com.example.site.model.Medico;
import com.example.site.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicoController {
    private MedicoService medicoService;

    @PostMapping("/autenticar")
    public ResponseEntity<Medico> autenticarMedico(@RequestParam String CRM, @RequestParam String senha) {
        Medico medico = medicoService.autenticarMedico(CRM, senha);
        if (medico != null) {
            return ResponseEntity.ok(medico);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    // Outros endpoints relacionados aos médicos
}
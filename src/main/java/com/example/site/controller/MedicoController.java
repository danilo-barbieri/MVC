package com.example.site.controller;

import com.example.site.model.Medico;
import com.example.site.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/medicos")
    public ResponseEntity<List<Medico>> listarTodosOsMedicos() {
        List<Medico> medicos = medicoService.listarTodosOsMedicos();
        return ResponseEntity.ok(medicos);
    }

    @PostMapping("/medicos")
    public ResponseEntity<Medico> criarNovoMedico(@RequestBody Medico medico) {
        Medico novoMedico = medicoService.criarNovoMedico(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMedico);
    }

    @PutMapping("/medicos/{id}")
    public ResponseEntity<Medico> atualizarInformacoesMedico(@PathVariable Long id, @RequestBody Medico medico) {
        Medico atualizadoMedico = medicoService.atualizarInformacoesMedico(id, medico);
        if (atualizadoMedico!= null) {
            return ResponseEntity.ok(atualizadoMedico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/medicos/{id}")
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }
}
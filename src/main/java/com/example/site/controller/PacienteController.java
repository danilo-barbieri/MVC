package com.example.site.controller;

import com.example.site.model.Paciente;
import com.example.site.model.PacienteDTO;
import com.example.site.model.Receita;
import com.example.site.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public Paciente cadastrarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return pacienteService.cadastrarPaciente(pacienteDTO.getNome(), pacienteDTO.getCpf(), pacienteDTO.getPlanoSaude());
    }

    @GetMapping("/{id}")
    public Paciente buscarPacientePorId(@PathVariable Long id) {
        return pacienteService.buscarPacientePorId(id);
    }

    @GetMapping("/{id}/receitas")
    public List<Receita> listarReceitasDoPaciente(@PathVariable Long id) {
        return pacienteService.listarReceitasDoPaciente(id);
    }

    // Outros métodos do controlador relacionados aos pacientes
}

package com.example.site.controller;

import com.example.site.model.Paciente;
import com.example.site.model.Receita;
import com.example.site.model.ReceitaDTO;
import com.example.site.service.PacienteService;
import com.example.site.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    private final PacienteService pacienteService;
    private final ReceitaService receitaService;

    @Autowired
    public ReceitaController(PacienteService pacienteService, ReceitaService receitaService) {
        this.pacienteService = pacienteService;
        this.receitaService = receitaService;
    }

    @GetMapping("/paciente/{id}")
    public List<Receita> listarReceitasPorPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPacientePorId(id);
        if (paciente != null) {
            return receitaService.listarReceitasPorPaciente(paciente);
        } else {
            // Tratar o caso em que o paciente não foi encontrado
            return new ArrayList<>();
        }
    }

    // Outros métodos do controlador relacionados às receitas
}

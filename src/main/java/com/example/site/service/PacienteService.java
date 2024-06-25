package com.example.site.service;

import com.example.site.model.Medicamento;
import com.example.site.model.Medico;
import com.example.site.model.Paciente;
import com.example.site.model.Receita;
import com.example.site.repository.PacienteRepository;
import com.example.site.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ReceitaService receitaService;

    public Paciente cadastrarPaciente(String nome, String cpf, String planoSaude) {
        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setCPF(cpf);
        paciente.setPlanoSaude(planoSaude);

        // Lógica adicional, como validações, geração de ID, etc.

        return pacienteRepository.save(paciente);
    }

    public Paciente buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public List<Receita> listarReceitasDoPaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente != null) {
            return receitaService.listarReceitasPorPaciente(paciente);
        }
        return new ArrayList<>();
    }

    // Outros métodos de serviço relacionados aos pacientes
}
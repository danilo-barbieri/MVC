package com.example.site.service;

import com.example.site.model.Paciente;
import com.example.site.model.Receita;
import com.example.site.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ReceitaService receitaService;

    public Paciente cadastrarPaciente(String nome, String cpf, String planoSaude) {
        //validação nome e CPF não null
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio");
        }

        //validação duplicidade de CPF
        Optional<Paciente> existente = pacienteRepository.findByCPF(cpf);
        if (existente.isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setCPF(cpf);
        paciente.setPlanoSaude(planoSaude);

        return pacienteRepository.save(paciente);
    }

    public Paciente buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente buscarPacientePorCpf(String cpf) {
        return pacienteRepository.findByCPF(cpf).orElse(null);
    }

    public List<Receita> listarReceitasDoPaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente != null) {
            return receitaService.listarReceitasPorPaciente(paciente);
        }
        return new ArrayList<>();
    }

    public Paciente atualizarPaciente(Long id, String nome, String cpf, String planoSaude) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()) {
            Paciente paciente = optionalPaciente.get();
            paciente.setNome(nome);
            paciente.setCPF(cpf);
            paciente.setPlanoSaude(planoSaude);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    //buscar por nome
    public List<Paciente> buscarPacientesPorNome(String nome) {
        return pacienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    //listar todos os pacientes
    public List<Paciente> listarTodosOsPacientes() {
        return pacienteRepository.findAll();
    }

    //alterar paciente
    public Paciente alterarPaciente(Long id, String nome, String cpf, String planoSaude) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(id);
        if (pacienteOpt.isPresent()) {
            Paciente paciente = pacienteOpt.get();
            paciente.setNome(nome);
            paciente.setCPF(cpf);
            paciente.setPlanoSaude(planoSaude);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    //deletar paciente
    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
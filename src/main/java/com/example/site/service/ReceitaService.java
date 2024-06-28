package com.example.site.service;

import com.example.site.model.Medicamento;
import com.example.site.model.Medico;
import com.example.site.model.Paciente;
import com.example.site.model.Receita;
import com.example.site.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

        @Autowired
        private ReceitaRepository receitaRepository;

        public Receita criarReceita(Paciente paciente, Medico medico, Medicamento medicamento) {

                //validações de preenchimento do paciente, do médico e do medicamento
                if (paciente == null) {
                        throw new IllegalArgumentException("Paciente não pode ser nulo");
                }
                if (medico == null) {
                        throw new IllegalArgumentException("Médico não pode ser nulo");
                }
                if (medicamento == null) {
                        throw new IllegalArgumentException("Medicamento não pode ser nulo");
                }

                Receita receita = new Receita();
                receita.setPaciente(paciente);
                receita.setMedico(medico);
                receita.setMedicamento(medicamento);
                receita.setDataHoraEnvio(new Date());
                return receitaRepository.save(receita);
        }

        public List<Receita> listarReceitasPorPaciente(Paciente paciente) {
                if (paciente == null) {
                        throw new IllegalArgumentException("Paciente não pode ser nulo");
                }
                return receitaRepository.findByPaciente(paciente);
        }

        public Receita buscarReceitaPorId(Long id) {
                return receitaRepository.findById(id).orElse(null);
        }

        public List<Receita> listarReceitasPorMedico(Medico medico) {
                if (medico == null) {
                        throw new IllegalArgumentException("Médico não pode ser nulo");
                }
                return receitaRepository.findByMedico(medico);
        }

        public List<Receita> listarReceitasPorPeriodo(Date inicio, Date fim) {
                if (inicio == null || fim == null) {
                        throw new IllegalArgumentException("Datas de início e fim não podem ser nulas");
                }
                if (inicio.after(fim)) {
                        throw new IllegalArgumentException("A data de início não pode ser posterior à data de fim");
                }
                return receitaRepository.findByDataHoraEnvioBetween(inicio, fim);
        }

        public Receita atualizarReceita(Long id, Paciente paciente, Medico medico, Medicamento medicamento) {
                Optional<Receita> optionalReceita = receitaRepository.findById(id);
                if (optionalReceita.isPresent()) {
                        Receita receita = optionalReceita.get();
                        receita.setPaciente(paciente);
                        receita.setMedico(medico);
                        receita.setMedicamento(medicamento);
                        return receitaRepository.save(receita);
                }
                return null;
        }

        public void deletarReceita(Long id) {
                receitaRepository.deleteById(id);
        }
}
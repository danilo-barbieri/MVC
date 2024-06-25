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

        @Service
        public class ReceitaService {

                @Autowired
                private ReceitaRepository receitaRepository;

                public Receita criarReceita(Paciente paciente, Medico medico, Medicamento medicamento) {
                        Receita receita = new Receita();
                        receita.setPaciente(paciente);
                        receita.setMedico(medico);
                        receita.setMedicamento(medicamento);
                        receita.setDataHoraEnvio(new Date());

                        // Lógica adicional, como validações, cálculos, etc.

                        return receitaRepository.save(receita);
                }

                public List<Receita> listarReceitasPorPaciente(Paciente paciente) {
                        return receitaRepository.findByPaciente(paciente);
                }

                // Outros métodos de serviço relacionados às receitas
        }

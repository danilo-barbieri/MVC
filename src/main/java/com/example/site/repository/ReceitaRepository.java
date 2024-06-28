package com.example.site.repository;

import com.example.site.model.Medico;
import com.example.site.model.Paciente;
import com.example.site.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    List<Receita> findByPaciente(Paciente paciente);

    List<Receita> findByDataHoraEnvioBetween(Date inicio, Date fim);

    List<Receita> findByMedico(Medico medico);
}
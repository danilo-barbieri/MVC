package com.example.site.repository;

import com.example.site.model.Paciente;
import com.example.site.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    List<Receita> findByPaciente(Paciente paciente);
}
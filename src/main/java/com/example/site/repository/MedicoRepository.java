package com.example.site.repository;

import com.example.site.model.Medico;
import java.util.List;
import java.util.Optional;

public interface MedicoRepository {
    Medico findByCRM(String CRM);

    List<Medico> findAll();

    Medico save(Medico medico);

    Optional<Medico> findById(Long id);

    void deleteById(Long id);
}
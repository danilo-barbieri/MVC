package com.example.site.repository;

import com.example.site.model.Medico;

public interface MedicoRepository {
    Medico findByCRM(String CRM);
    // Outros métodos de acesso a dados
}
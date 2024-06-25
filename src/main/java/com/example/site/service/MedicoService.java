package com.example.site.service;

import com.example.site.model.Medico;
import com.example.site.repository.MedicoRepository;

public class MedicoService {
    private MedicoRepository medicoRepository;

    public Medico autenticarMedico(String CRM, String senha) {
        Medico medico = medicoRepository.findByCRM(CRM);

        if (medico != null && senhaCorreta(medico, senha)) {
            return medico;
        } else {
            return null;
        }
    }

    private boolean senhaCorreta(Medico medico, String senha) {
        // Lógica para verificar se a senha informada está correta
        // Aqui você pode comparar a senha informada com a senha armazenada do médico
        // Pode ser necessário aplicar técnicas de segurança como hash e salt
        return medico.getSenha().equals(senha);
    }

    // Outros métodos de serviço relacionados aos médicos
}

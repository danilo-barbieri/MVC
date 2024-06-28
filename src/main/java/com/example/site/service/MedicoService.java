package com.example.site.service;

import com.example.site.model.Medico;
import com.example.site.repository.MedicoRepository;

import java.util.List;

public class MedicoService {
    private MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico autenticarMedico(String CRM, String senha) {
        Medico medico = medicoRepository.findByCRM(CRM);

        if (medico!= null && senhaCorreta(medico, senha)) {
            return medico;
        } else {
            return null;
        }
    }

    private boolean senhaCorreta(Medico medico, String senha) {
        return medico.getSenha().equals(senha);
    }

    //listagem de todos os médicos
    public List<Medico> listarTodosOsMedicos() {
        return medicoRepository.findAll();
    }

    // cadastrar novo médico
    public Medico criarNovoMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    // atualizar médico
    public Medico atualizarInformacoesMedico(Long id, Medico medicoAtualizado) {
        return medicoRepository.findById(id)
                .map(medico -> {
                    medico.setNomeCompleto(medicoAtualizado.getNomeCompleto());
                    medico.setCRM(medicoAtualizado.getCRM());
                    medico.setAssinaturaDigital(medicoAtualizado.getAssinaturaDigital());
                    medico.setSenha(medicoAtualizado.getSenha());
                    return medicoRepository.save(medico);
                })
                .orElse(null);
    }

    //deletar médico
    public void deletarMedico(Long id) {
        medicoRepository.deleteById(id);
    }
}
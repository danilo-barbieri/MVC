package com.example.site.model;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column
    private String nome;
    @Column
    private String dataNascimento;
    @Column
    private String CPF;
    @Column
    private String planoSaude;


    public String getNome() {
        return nome;
    }

    public void setNome(String nomeCompleto) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public long getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }
}

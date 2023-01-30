package com.cxacademy.model.dto;

import com.cxacademy.model.PessoaModel;

import java.time.LocalDate;

public class PessoaDto {

    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNasc;
    private String estadoCivil;
    private String telefone;
    private String email;

    public PessoaDto() {

    }

    public PessoaDto(PessoaModel pessoaModel) {
        this.id = pessoaModel.getId();
        this.nome = pessoaModel.getNome();
        this.cpf = pessoaModel.getCpf();
        this.rg = pessoaModel.getRg();
        this.dataNasc = pessoaModel.getDataNasc();
        this.estadoCivil = pessoaModel.getEstadoCivil();
        this.telefone = pessoaModel.getTelefone();
        this.email = pessoaModel.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

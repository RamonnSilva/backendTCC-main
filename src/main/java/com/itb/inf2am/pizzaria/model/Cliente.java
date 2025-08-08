package com.itb.inf2am.pizzaria.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(nullable = false, length = 255)  // Removido unique para senha
    private String senha;

    @Column(nullable = true, length = 9)    // Removido unique para cep
    private String cep;

    @Column(nullable = true, length = 20)   // Removido unique para telefone
    private String telefone;

    @Column(nullable = true, length = 255)
    private String endereco;

    @Column(nullable = true, length = 2)
    private String estado;



    @Column(nullable = true, length = 255)
    private String cidade;

    @Column(name = "datanascimento")
    private LocalDate datanascimento;



    @Column(nullable = true, length = 4)
    private Integer logradouro;

    @Transient
    private String message = "";

    @Transient
    private boolean isValid = true;

    // Construtor padrão
    public Cliente() {}

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // NOME
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // EMAIL
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // SENHA
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // CEP (remove hífen se houver)
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep != null) {
            this.cep = cep.replaceAll("-", "");
        } else {
            this.cep = null;
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Integer logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public LocalDate getDataNascimento() {
        return datanascimento;
    }

    public void setDataNascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }

    // TELEFONE
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // MENSAGEM
    public String getMessage() {
        return message;
    }

    // VALIDAÇÃO (implementar sua regra aqui)
    public boolean validarCliente() {
        return isValid;
    }
}

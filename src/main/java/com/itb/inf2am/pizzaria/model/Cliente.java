package com.itb.inf2am.pizzaria.model;

import jakarta.persistence.*;

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

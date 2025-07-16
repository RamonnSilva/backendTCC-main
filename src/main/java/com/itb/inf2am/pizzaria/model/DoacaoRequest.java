package com.itb.inf2am.pizzaria.model;

public class DoacaoRequest {

    private String nome;
    private String titulo;
    private String genero;
    private String autor;
    private String descricao;
    private String imagem; // base64

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getImagem() { return imagem; }
    public void setImagem(String imagem) { this.imagem = imagem; }
}

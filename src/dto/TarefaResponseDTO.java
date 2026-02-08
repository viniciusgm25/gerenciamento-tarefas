package com.vinicius.tarefas.dto;

public class TarefaResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluida;

    public TarefaResponseDTO(Long id, String titulo, String descricao, boolean concluida) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = concluida;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }
}

package com.example.to_do_list.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_TAREFAS")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefas;

    private String nome;
    private String descricao;
    private boolean realizado;
    private int prioridade;

    public Long getIdTarefas(){
        return idTarefas;
    }
    public void setIdTarefas(Long idTarefas){
        this.idTarefas = idTarefas;
    }

    private String getNome(){
        return nome;
    }
    private void setNome(String nome){
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}

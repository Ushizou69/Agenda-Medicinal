/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Ushizou
 */
public class Agenda {

    private LocalDateTime data;
    private String nome;
    private String descricao;
    private Tarefa tarefa;
    private boolean concluida;

    public Agenda(LocalDateTime data, String nome, String descricao, Tarefa tarefa, boolean concluida) {
        this.data = data;
        this.nome = nome;
        this.descricao = descricao;
        this.tarefa = tarefa;
        this.concluida = concluida;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.data);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.descricao);
        hash = 89 * hash + Objects.hashCode(this.tarefa);
        hash = 89 * hash + (this.concluida ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agenda other = (Agenda) obj;
        if (this.concluida != other.concluida) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return Objects.equals(this.tarefa, other.tarefa);
    }

    @Override
    public String toString() {
        return """
           ========================================
                         ITEM DA AGENDA
           ========================================
           Compromisso       : %s
           Data e Hora       : %s
           Descricao         : %s
           Status            : %s
           Tarefa Vinculada  : %s
           ========================================
           """.formatted(
                nome,
                data,
                descricao,
                concluida ? "Concluído" : "Pendente",
                tarefa != null ? tarefa.toString() : "Nenhuma"
        );

    }
}

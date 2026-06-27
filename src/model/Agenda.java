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
    private Remedio remedio;
    private Tarefa tarefa;
    private boolean concluida;

    // Construtor focado em remédio
    public Agenda(LocalDateTime data, String nome, String descricao, Remedio remedio, boolean concluida) {
        this.data = data;
        this.nome = nome;
        this.descricao = descricao;
        this.remedio = remedio;
        this.concluida = concluida;
    }

    // Construtor completo: remédio + tarefa juntos
    public Agenda(LocalDateTime data, String nome, String descricao, Remedio remedio, Tarefa tarefa, boolean concluida) {
        this(data, nome, descricao, remedio, concluida);
        this.tarefa = tarefa;
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
    
    public Remedio getRemedio() {
        return remedio;
    }
    
    public void setRemedio(Remedio remedio) {
        this.remedio = remedio; 
    }

    // Verifica se está dentro do prazo do remédio vinculado
    public String getStatusRemedio() {
        if (remedio == null) return "Nenhum remédio vinculado";
        return remedio.getStatusMedicacao();
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
           Remedio Vinculado : %s
           Tarefa Vinculada  : %s
           ========================================
           """.formatted(
                nome,
                data,
                descricao,
                concluida ? "Concluído" : "Pendente",
                remedio != null ? remedio.getNome() + " — " + remedio.getStatusMedicacao(): "Nenhum",
                tarefa != null ? tarefa.getNome() : "Nenhuma"
        );

    }
}

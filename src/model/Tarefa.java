/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author 2025001861
 */
public class Tarefa implements Comparable<Tarefa> {

    private String nome;
    private String descricao;
    private LocalDate dataLimite;
    private Categoria categoria;
    private int prioridade;
    private boolean concluida;

    public Tarefa(String nome, String descricao, LocalDate dataLimite, Categoria categoria, int prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataLimite = dataLimite;
        this.categoria = categoria;
        setPrioridade(prioridade);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPrioridade(int prioridade) {
        if (prioridade >= 1 && prioridade <= 3) {
            this.prioridade = prioridade;
        }
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public void dataLimite() {
        LocalDate hoje = LocalDate.now();

        if (hoje.isAfter(dataLimite)) {
            System.out.println("O prazo expirou!");
        } else {
            System.out.println("Voce ainda este no prazo.");
        }
    }

    @Override
    public int compareTo(Tarefa outra) {
        return Integer.compare(outra.prioridade, this.prioridade);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.descricao);
        hash = 47 * hash + Objects.hashCode(this.dataLimite);
        hash = 47 * hash + Objects.hashCode(this.categoria);
        hash = 47 * hash + this.prioridade;
        hash = 47 * hash + (this.concluida ? 1 : 0);
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
        final Tarefa other = (Tarefa) obj;
        if (this.prioridade != other.prioridade) {
            return false;
        }
        if (this.concluida != other.concluida) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.dataLimite, other.dataLimite)) {
            return false;
        }
        return this.categoria == other.categoria;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "nome=" + nome + " descricao=" + descricao + ", datalimite=" + dataLimite + ", categoria=" + categoria + ", prioridade=" + prioridade + ", concluida=" + concluida + '}';
    }
}
